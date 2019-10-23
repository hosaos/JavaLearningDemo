package bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用户信息实体
 *
 * @author: chenyin
 * @date: 2019-10-22 13:39
 */
@Getter
@Setter
@NoArgsConstructor
public class UserInfo {
    private Long id;
    private String userName;

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                '}';
    }
}
