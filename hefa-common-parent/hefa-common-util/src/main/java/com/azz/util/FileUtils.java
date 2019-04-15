package com.azz.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @version 1.0
 * @author 黄雄星（13077862552） 2014-5-22 下午5:11:24
 */
@Slf4j
public class FileUtils extends org.apache.commons.io.FileUtils {


    /**
     * 
     * getFileSuffix:. 获取文件的后缀名<br/>
     * 
     * @author zjj
     * @param fileName 包含文件的后缀名
     * @return
     * @since JDK 1.7
     */
    public static String getFileSuffix(String fileName) {
        if (fileName.indexOf(".") > -1) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return null;
    }

    /**
     * 
     * <p>
     * 通过ftp下载文件
     * </p>
     * 
     * @param ip
     * @param userName
     * @param pwd
     * @param remoteFileName
     * @param downLoadFileName
     * @author 黄雄星（13077862552） 2014-5-22 下午5:19:42
     */
    public static void ftpDownload(String ip, String userName, String pwd, String remoteFileName,
            String downLoadFileName, Integer port) {
        FTPClient ftpClient = new FTPClient();
        FileOutputStream fos = null;

        try {
            if (port == null) {
                port = 21;

            }
            ftpClient.connect(ip, port);
            ftpClient.login(userName, pwd);

            fos = new FileOutputStream(downLoadFileName);
            // 设置PassiveMode传输
            ftpClient.enterLocalPassiveMode();
            // 设置以二进制流的方式传输
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            ftpClient.setBufferSize(1024);
            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("----------->>>连接ftp服务器失败！");
            } else {
                ftpClient.retrieveFile(remoteFileName, fos);
            }
        } catch (IOException e) {
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            IOUtils.closeQuietly(fos);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }

    /**
     * 
     * <p>
     * 通过ftp上传文件到ftp服务器
     * </p>
     * 
     * @param ip : ftp服务器的ip地址
     * @param userName ：ftp服务器登陆用户名
     * @param pwd ：ftp服务器登陆密码
     * @param remotePath ：ftp服务器的文件目录
     * @param remoteFileName ：ftp服务器的文件名（不带路径）
     * @param upLoadFileName：需要上传的本地的带路径的文件名
     * @param port ：端口
     * @author 朱建谱（15626573212） 2015-1-21 下午6:03:54
     */
    public static void ftpUpload(String ip, String userName, String pwd, String remotePath,
            String remoteFileName, String upLoadFileName, Integer port) {
        FTPClient ftpClient = new FTPClient();
        FileInputStream fos = null;

        try {
            if (port == null) {
                port = 21;

            }
            ftpClient.connect(ip, port);
            ftpClient.setConnectTimeout(100000);
            ftpClient.login(userName, pwd);
            fos = new FileInputStream(upLoadFileName);
            // 设置PassiveMode传输
            ftpClient.enterLocalPassiveMode();
            // 设置以二进制流的方式传输
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            ftpClient.setBufferSize(1024);
            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("----------->>>连接ftp服务器失败！");
            } else {
                ftpClient.changeWorkingDirectory(remotePath);
                ftpClient.storeFile(remoteFileName, fos);
            }
        } catch (IOException e) {
            log.error("FTP客户端出错!", e);
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            IOUtils.closeQuietly(fos);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }

    /**
     * 
     * <p>
     * 获取资源文件绝对路径
     * </p>
     * 
     * @param clazz
     * @return 返回带"/"的资源文件路径; eg: D:/workspaces/slsy-common/target/classes/
     * @author 黄雄星（13077862552） 2013-12-5 下午1:41:27
     */
    public static String getCurrentResourcePath(Class<?> clazz) {
        String osName = System.getProperty("os.name");
        String resourcePath = clazz.getResource("/").getPath();
        if (osName.toLowerCase().contains("windows")) {
            // ,当windows下是路径前面会多一个"/",需要去除
            resourcePath = resourcePath.substring(1, resourcePath.length());
        }
        log.debug("获取的资源绝对路径为resourcePath[{}]", resourcePath);
        return resourcePath;
    }

    /**
     * 
     * <p>
     * 删除ftp文件
     * </p>
     * 
     * @param ip
     * @param userName
     * @param pwd
     * @param remotePath
     * @param remoteFileName
     * @param port
     * @author 朱建谱（15626573212） 2015-6-30 下午5:18:50
     */
    public static void ftpDeleteFile(String ip, String userName, String pwd, String remotePath,
            Integer port) {
        FTPClient ftpClient = new FTPClient();
        try {
            if (port == null) {
                port = 21;
            }
            ftpClient.connect(ip, port);
            ftpClient.login(userName, pwd);
            // 设置PassiveMode传输
            ftpClient.enterLocalPassiveMode();
            // 设置以二进制流的方式传输
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            ftpClient.setBufferSize(1024);
            // 设置文件类型（二进制）
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("----------->>>连接ftp服务器失败！");
            } else {
                ftpClient.changeWorkingDirectory(remotePath);
                FTPFile[] files = ftpClient.listFiles();
                for (int i = 0; i < files.length; i++) {
                    boolean result = ftpClient.deleteFile(files[i].getName());
                    log.info("删除文件FileName[{}]结果result[{}]", files[i].getName(), result);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }

    /**
     * 文件重命名
     * 
     * @param path 文件目录
     * @param oldname 原来的文件名
     * @param newname 新文件名
     */
    public static void renameFile(String path, String oldname, String newname) {
        // 新的文件名和以前文件名不同时,才有必要进行重命名
        if (!oldname.equals(newname)) {
            File oldfile = new File(path + "/" + oldname);
            File newfile = new File(path + "/" + newname);
            // 重命名文件不存在
            if (!oldfile.exists()) {
                log.info(oldfile.getAbsolutePath() + "不存在！");
                return;
            }
            // 若在该目录下已经有一个文件和新文件名相同，则不允许重命名
            if (newfile.exists()) {
                log.info(newname + "已经存在");
            } else {
                oldfile.renameTo(newfile);
                log.info(oldname + "已重命名为" + newname);
            }
        }
    }

    public static void main(String[] args) {
        ftpDeleteFile("113.108.72.53", "s1298001", "1298001slsy2015", "/cardrisk/", 21);
    }
}
