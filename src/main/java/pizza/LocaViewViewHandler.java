package pizza;

import pizza.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LocaViewViewHandler {


    @Autowired
    private LocaViewRepository locaViewRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLocationSaved_then_CREATE_1 (@Payload LocationSaved locationSaved) {
        try {
            if (locationSaved.isMe()) {
                // view 객체 생성
                LocaView locaView = new LocaView();
                // view 객체에 이벤트의 Value 를 set 함
                locaView.setOrderId(locationSaved.getOrderId());
                locaView.setNowStatus(locationSaved.getNowStatus());
                locaView.setDesc(locationSaved.getDesc());
                // view 레파지 토리에 save
                locaViewRepository.save(locaView);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}