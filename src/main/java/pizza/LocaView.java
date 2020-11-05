package pizza;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="LocaView_table")
public class LocaView {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderId;
        private String nowStatus;
        private String desc;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }
        public String getNowStatus() {
            return nowStatus;
        }

        public void setNowStatus(String nowStatus) {
            this.nowStatus = nowStatus;
        }
        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

}
