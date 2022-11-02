package gov.tubitak;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class StockController {
    private final String webUrl ="http://localhost:8081/stock/";
    private final RestTemplate restTemplate = new RestTemplate();
    @GetMapping("/pull")
    public ResponseEntity<List<StockDto>> get(){
        ResponseEntity s = restTemplate.getForEntity(webUrl+"get-stock", List.class);
        return s;
    }
    @PostMapping ("/push")
    public ResponseEntity<StockDto> add(@RequestBody StockDto stock){
        ResponseEntity s = restTemplate.postForEntity(webUrl+"save-stock", stock, StockDto.class);
        return s;
    }
}
