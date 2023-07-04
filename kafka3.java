
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PortfolioProducer {
    @Autowired
    private KafkaTemplate<String,String> stringMessageTemplate;
    @Autowired
    public PortfolioProducer(KafkaTemplate<String, String> stringMessageTemplate) {
        this.stringMessageTemplate = stringMessageTemplate;
    }

    public void sendMessage(String message){
        stringMessageTemplate.send(MessagingConstants.PORTFOLIO_SERVICE_CUSTOM_DTO_UPDATE,message);
    }
}
