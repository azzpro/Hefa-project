package com.hefa.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientInvoice;
import com.hefa.order.pojo.bo.SearchInvoiceInfoParam;
import com.hefa.order.pojo.vo.ExpressCompanyInfo;
import com.hefa.order.pojo.vo.InvoiceDetail;
import com.hefa.order.pojo.vo.InvoiceInfo;

@Mapper
public interface ClientInvoiceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientInvoice record);

    int insertSelective(ClientInvoice record);

    ClientInvoice selectByPrimaryKey(Long id);
    
    ClientInvoice selectByCode(String invoiceCode);
    
    int updateByPrimaryKeySelective(ClientInvoice record);

    int updateByPrimaryKey(ClientInvoice record);
    
    /**
     * 
     * <p>查询发票详情</p>
     * @param invoiceCode
     * @return
     * @author 黄智聪  2019年4月24日 下午6:55:06
     */
    InvoiceDetail getInvoiceDetail(String invoiceCode);
    
    /**
     * 
     * <p>查询发票信息列表</p>
     * @param param
     * @return
     * @author 黄智聪  2019年4月24日 下午7:32:29
     */
    List<InvoiceInfo> getInvoiceInfos(SearchInvoiceInfoParam param);
    
    /**
     * 
     * <p>是否存在快递公司</p>
     * @param expressCompanyId
     * @return
     * @author 黄智聪  2019年4月24日 下午7:52:18
     */
    int existExpressCompany(int expressCompanyId);
    
    /**
     * 
     * <p>查询所有快递公司信息</p>
     * @return
     * @author 黄智聪  2019年4月25日 上午10:52:05
     */
    List<ExpressCompanyInfo> getExpressCompanyInfos();
}