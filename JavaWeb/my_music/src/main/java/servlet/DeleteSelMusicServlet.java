package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.MusicDao;
import entity.Music;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DeleteSelMusicServlet
 * Description:    批量删除音乐
 * date: 2021/7/20 22:27
 *  优化: 批量删除可使用回滚(暂未使用)
 * @author wt
 * @since JDK 1.8
 */
@WebServlet("/deleteSelectMusic")
public class DeleteSelMusicServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");

        String[] values =  req.getParameterValues("id[]");
        System.out.println("要删除 music 的id 有 :"+ Arrays.toString(values));

        Map<String,Object>  return_map = new HashMap<>();

        MusicDao musicDao = new MusicDao();

        int sum = 0;
        // for循环一条一条删除
        for (int i = 0; i < values.length; i++) {
            //先查询，
            int musicId = Integer.parseInt(values[i]);
            Music music = musicDao.findMusicById(musicId);
            if (music == null) return;
            //再删除数据库数据
            int ret = musicDao.deleteMusicById(musicId);
            if (ret == 1) {
                //删除服务器上的数据
                File file = new File("E:\\编程软件\\代码\\IdeaProjects\\JavaWeb\\my_music\\src\\main\\webapp\\" +
                        music.getUrl()+".mp3");
                if (file.delete()) {
                    System.out.println("musicId 为"+musicId+"的数据库和文件内容都删除成功了！");
                    sum += ret;
                } else {
                    return_map.put("msg",false);
                    System.out.println("服务器文件删除失败哦！");
                }
            } else {
                return_map.put("msg",false);
                System.out.println("出现问题了！数据库和文件不一致，数据库删了，但文件可能还在哦！");
            }
        }

        if (sum == values.length) {
            return_map.put("msg",true);
            System.out.println("全部删除成功！");
        } else {
            return_map.put("msg",false);
            System.out.println("批量删除失败！！！");
        }
        //返回前端的响应
        ObjectMapper oj = new ObjectMapper();
        oj.writeValue(resp.getWriter(),return_map);
    }
}
