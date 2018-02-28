package response;

import java.util.ArrayList;
import java.util.List;

import bean.BaseBean;
import bean.HomeworkDetailBean;
import bean.PageBean;
import bean.StatusBean;

/**
 * Created by srt-k12001 on 2017/12/19.
 */

public class HomeWorkResponse extends BaseResponse {

    protected PageBean page;
    protected List<HomeworkDetailBean> data = new ArrayList<HomeworkDetailBean>();

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public List<HomeworkDetailBean> getData() {
        return data;
    }

    public void setData(List<HomeworkDetailBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HomeWorkResponse{" +
                "page=" + page +
                ", data=" + data +
                '}';
    }
}