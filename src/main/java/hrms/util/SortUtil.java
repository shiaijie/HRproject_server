package hrms.util;

import com.baomidou.mybatisplus.mapper.Wrapper;
import hrms.entity.SystemConstants;
import org.apache.commons.lang3.StringUtils;
import pojo.PageAo;

import java.util.Map;

public class SortUtil {

    private final static String SORT_FIELD_END = "end";
    private final static String SORT_FIELD_ASC = "asc";
    private final static String SORT_FIELD_DESC = "desc";

    public static void sortField(String sortName, String sortValue, Wrapper ew) {
        // 名称中文排序
//        if (StringUtils.isNotBlank(sortName)
//                && (sortName.contains("name") || sortName.contains("Name"))) {
//            sortName = "convert(" + sortName + " using gbk)";
//        }

        if (sortValue.contains(SORT_FIELD_END)) {
            if(SORT_FIELD_ASC.equals(sortValue.substring(0, sortValue.indexOf(SORT_FIELD_END)))){
                ew.orderBy(sortName,true);
            } else if(SORT_FIELD_DESC.equals(sortValue.substring(0, sortValue.indexOf(SORT_FIELD_END)))){
                ew.orderBy(sortName,false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void genOrderBy(Map params) {
        String sortName = (String) params.get(SystemConstants.SORT_NAME);
        String sortValue = (String) params.get(SystemConstants.SORT_VALUE);
        if (StringUtils.isNotBlank(sortName) && StringUtils.isNotBlank(sortValue)) {
            if (sortValue.contains(SystemConstants.SORT_END)) {
                // 名称中文排序
//                if (sortName.contains("name") || sortName.contains("Name")) {
//                    sortName = "convert(" + sortName + " using gbk)";
//                }
//                params.put(SystemConstants.SORT_NAME, sortName);
                params.put(SystemConstants.SORT_VALUE, sortValue.substring(0, sortValue.indexOf(SystemConstants.SORT_END)));
            }
        }
    }

    public static void genOrderBy(PageAo params) {
        String sortValue = params.getSortValue();
        if (StringUtils.isNotBlank(params.getSortName()) && StringUtils.isNotBlank(sortValue)) {
            if (sortValue.contains(SystemConstants.SORT_END)) {
                params.setSortValue(sortValue.substring(0, sortValue.indexOf(SystemConstants.SORT_END)));
            }
        }
    }
}
