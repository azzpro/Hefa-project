package com.azz.client.pojo;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PlatformIndexArticle implements Serializable {
    private Long id;

    /**
     * 关联栏目id
     *
     * @mbg.generated
     */
    private Long indexColumnId;

    /**
     * 文章标题
     *
     * @mbg.generated
     */
    private String articleTitle;

    /**
     * 文章主图名称
     *
     * @mbg.generated
     */
    private String articlePicName;

    /**
     * 文章主图url
     *
     * @mbg.generated
     */
    private String articlePicUrl;

    /**
     * 价格
     *
     * @mbg.generated
     */
    private BigDecimal price;

    /**
     * 创建人
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 最后更新时间
     *
     * @mbg.generated
     */
    private Date lastModifyTime;

    /**
     * 修改人
     *
     * @mbg.generated
     */
    private String modifier;

    /**
     * 备注1
     *
     * @mbg.generated
     */
    private String remark1;

    /**
     * 备注2
     *
     * @mbg.generated
     */
    private String remark2;

    /**
     * 文章内容
     *
     * @mbg.generated
     */
    private String articleContent;

    private static final long serialVersionUID = 1L;

    /**
     * <br/>
     * 返回值对应的表列名 platform_index_article.id
     *
     * @return 返回值对应 platform_index_article.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * <br/>
     * platform_index_article.id
     *
     * @param id 值对应 platform_index_article.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 关联栏目id<br/>
     * 返回值对应的表列名 platform_index_article.index_column_id
     *
     * @return 返回值对应 platform_index_article.index_column_id
     *
     * @mbg.generated
     */
    public Long getIndexColumnId() {
        return indexColumnId;
    }

    /**
     * 关联栏目id<br/>
     * platform_index_article.index_column_id
     *
     * @param indexColumnId 值对应 platform_index_article.index_column_id
     *
     * @mbg.generated
     */
    public void setIndexColumnId(Long indexColumnId) {
        this.indexColumnId = indexColumnId;
    }

    /**
     * 文章标题<br/>
     * 返回值对应的表列名 platform_index_article.article_title
     *
     * @return 返回值对应 platform_index_article.article_title
     *
     * @mbg.generated
     */
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * 文章标题<br/>
     * platform_index_article.article_title
     *
     * @param articleTitle 值对应 platform_index_article.article_title
     *
     * @mbg.generated
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    /**
     * 文章主图名称<br/>
     * 返回值对应的表列名 platform_index_article.article_pic_name
     *
     * @return 返回值对应 platform_index_article.article_pic_name
     *
     * @mbg.generated
     */
    public String getArticlePicName() {
        return articlePicName;
    }

    /**
     * 文章主图名称<br/>
     * platform_index_article.article_pic_name
     *
     * @param articlePicName 值对应 platform_index_article.article_pic_name
     *
     * @mbg.generated
     */
    public void setArticlePicName(String articlePicName) {
        this.articlePicName = articlePicName == null ? null : articlePicName.trim();
    }

    /**
     * 文章主图url<br/>
     * 返回值对应的表列名 platform_index_article.article_pic_url
     *
     * @return 返回值对应 platform_index_article.article_pic_url
     *
     * @mbg.generated
     */
    public String getArticlePicUrl() {
        return articlePicUrl;
    }

    /**
     * 文章主图url<br/>
     * platform_index_article.article_pic_url
     *
     * @param articlePicUrl 值对应 platform_index_article.article_pic_url
     *
     * @mbg.generated
     */
    public void setArticlePicUrl(String articlePicUrl) {
        this.articlePicUrl = articlePicUrl == null ? null : articlePicUrl.trim();
    }

    /**
     * 价格<br/>
     * 返回值对应的表列名 platform_index_article.price
     *
     * @return 返回值对应 platform_index_article.price
     *
     * @mbg.generated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 价格<br/>
     * platform_index_article.price
     *
     * @param price 值对应 platform_index_article.price
     *
     * @mbg.generated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 创建人<br/>
     * 返回值对应的表列名 platform_index_article.creator
     *
     * @return 返回值对应 platform_index_article.creator
     *
     * @mbg.generated
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建人<br/>
     * platform_index_article.creator
     *
     * @param creator 值对应 platform_index_article.creator
     *
     * @mbg.generated
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建时间<br/>
     * 返回值对应的表列名 platform_index_article.create_time
     *
     * @return 返回值对应 platform_index_article.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间<br/>
     * platform_index_article.create_time
     *
     * @param createTime 值对应 platform_index_article.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后更新时间<br/>
     * 返回值对应的表列名 platform_index_article.last_modify_time
     *
     * @return 返回值对应 platform_index_article.last_modify_time
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * 最后更新时间<br/>
     * platform_index_article.last_modify_time
     *
     * @param lastModifyTime 值对应 platform_index_article.last_modify_time
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * 修改人<br/>
     * 返回值对应的表列名 platform_index_article.modifier
     *
     * @return 返回值对应 platform_index_article.modifier
     *
     * @mbg.generated
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改人<br/>
     * platform_index_article.modifier
     *
     * @param modifier 值对应 platform_index_article.modifier
     *
     * @mbg.generated
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 备注1<br/>
     * 返回值对应的表列名 platform_index_article.remark1
     *
     * @return 返回值对应 platform_index_article.remark1
     *
     * @mbg.generated
     */
    public String getRemark1() {
        return remark1;
    }

    /**
     * 备注1<br/>
     * platform_index_article.remark1
     *
     * @param remark1 值对应 platform_index_article.remark1
     *
     * @mbg.generated
     */
    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    /**
     * 备注2<br/>
     * 返回值对应的表列名 platform_index_article.remark2
     *
     * @return 返回值对应 platform_index_article.remark2
     *
     * @mbg.generated
     */
    public String getRemark2() {
        return remark2;
    }

    /**
     * 备注2<br/>
     * platform_index_article.remark2
     *
     * @param remark2 值对应 platform_index_article.remark2
     *
     * @mbg.generated
     */
    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    /**
     * 文章内容<br/>
     * 返回值对应的表列名 platform_index_article.article_content
     *
     * @return 返回值对应 platform_index_article.article_content
     *
     * @mbg.generated
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 文章内容<br/>
     * platform_index_article.article_content
     *
     * @param articleContent 值对应 platform_index_article.article_content
     *
     * @mbg.generated
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PlatformIndexArticle other = (PlatformIndexArticle) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIndexColumnId() == null ? other.getIndexColumnId() == null : this.getIndexColumnId().equals(other.getIndexColumnId()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getArticlePicName() == null ? other.getArticlePicName() == null : this.getArticlePicName().equals(other.getArticlePicName()))
            && (this.getArticlePicUrl() == null ? other.getArticlePicUrl() == null : this.getArticlePicUrl().equals(other.getArticlePicUrl()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getRemark1() == null ? other.getRemark1() == null : this.getRemark1().equals(other.getRemark1()))
            && (this.getRemark2() == null ? other.getRemark2() == null : this.getRemark2().equals(other.getRemark2()))
            && (this.getArticleContent() == null ? other.getArticleContent() == null : this.getArticleContent().equals(other.getArticleContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIndexColumnId() == null) ? 0 : getIndexColumnId().hashCode());
        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
        result = prime * result + ((getArticlePicName() == null) ? 0 : getArticlePicName().hashCode());
        result = prime * result + ((getArticlePicUrl() == null) ? 0 : getArticlePicUrl().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getRemark1() == null) ? 0 : getRemark1().hashCode());
        result = prime * result + ((getRemark2() == null) ? 0 : getRemark2().hashCode());
        result = prime * result + ((getArticleContent() == null) ? 0 : getArticleContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", indexColumnId=").append(indexColumnId);
        sb.append(", articleTitle=").append(articleTitle);
        sb.append(", articlePicName=").append(articlePicName);
        sb.append(", articlePicUrl=").append(articlePicUrl);
        sb.append(", price=").append(price);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", modifier=").append(modifier);
        sb.append(", remark1=").append(remark1);
        sb.append(", remark2=").append(remark2);
        sb.append(", articleContent=").append(articleContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}