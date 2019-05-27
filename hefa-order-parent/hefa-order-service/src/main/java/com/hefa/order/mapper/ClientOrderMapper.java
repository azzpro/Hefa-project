package com.hefa.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hefa.order.pojo.ClientOrder;
import com.hefa.order.pojo.bo.SearchCommissionOrderInfoParam;
import com.hefa.order.pojo.bo.SearchOrderInfoParam;
import com.hefa.order.pojo.vo.CommissionOrderInfo;
import com.hefa.order.pojo.vo.Discount;
import com.hefa.order.pojo.vo.ExportOrderInfo;
import com.hefa.order.pojo.vo.OrderInfo;
import com.hefa.order.pojo.vo.ShippingAddressInfo;

@Mapper
public interface ClientOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ClientOrder record);

    int insertSelective(ClientOrder record);

    ClientOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ClientOrder record);
    
    int updateByOrderCodeSelective(ClientOrder record);

    int updateByPrimaryKey(ClientOrder record);
    
    /**
     * 
     * <p>查询订单列表</p>
     * @param param
     * @return
     * @author 黄智聪  2019年4月22日 下午7:53:40
     */
    List<OrderInfo> getOrderInfos(SearchOrderInfoParam param);
    
    /**
     * 
     * <p>查询订单详情</p>
     * @param orderCode
     * @return
     * @author 黄智聪  2019年4月22日 下午8:35:17
     */
    OrderInfo getOrderInfoByOrderCode(String orderCode);
    
    /**
     * 
     * <p>查询分佣订单列表</p>
     * @param param
     * @return
     * @author 黄智聪  2019年4月24日 下午4:40:30
     */
    List<CommissionOrderInfo> getCommissionOrderInfos(SearchCommissionOrderInfoParam param);
    
    /**
     * 
     * <p>查询用户的所属销售人员</p>
     * @param userCode
     * @return
     * @author 黄智聪  2019年5月5日 下午7:12:38
     */
    String getSalesmanCodeByUserCode(String userCode);
    
    /**
     * 
     * <p>查询收货地址</p>
     * @param userCode
     * @return
     * @author 黄智聪  2018年11月13日 下午3:28:37
     */
    ShippingAddressInfo getShippingAddressInfo(String shippingAddresscode);
    
    /**
     * 
     * <p>查询6小时未支付的客户订单编码集合</p>
     * @param clientOrderCode
     * @return
     * @author 黄智聪  2018年11月13日 上午11:06:57
     */
    List<String> getSixHoursNotPaidOrderCodes();
    
    /**
     * 
     * <p>分佣导出订单信息</p>
     * @param param
     * @return
     * @author 黄智聪  2019年5月10日 下午3:56:28
     */
    List<ExportOrderInfo> getExportOrderInfos(SearchCommissionOrderInfoParam param);
    
    /**
     * 
     * <p>获取折扣信息</p>
     * @param productCode
     * @return
     * @author 黄智聪  2019年5月24日 下午9:28:26
     */
    Discount getDiscountByProductCode(String productCode);
}