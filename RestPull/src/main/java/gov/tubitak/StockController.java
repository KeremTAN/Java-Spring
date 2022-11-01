package gov.tubitak;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/getStock")
@RequiredArgsConstructor
public class StockController {
    private String webUrl ="http://localhost:8081/stock/h2";
    private RestTemplate restTemplate = new RestTemplate();
    @GetMapping
    public ResponseEntity<List<StockDto>> get(){
        ResponseEntity s = restTemplate.getForEntity(webUrl, List.class);
        System.out.println(s);
        return s;
    }
}
