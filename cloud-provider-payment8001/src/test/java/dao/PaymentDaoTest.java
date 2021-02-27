package dao;

import com.sheli.PaymentMain8001;
import com.sheli.dao.PaymentDao;
import com.sheli.entities.Payment;
import com.sheli.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentMain8001.class)
public class PaymentDaoTest {

    @Autowired
    private PaymentDao paymentDao;

    @Before
    public void prepareTest() {
        log.info("Preparing test.");
    }

    @Test
    public void dbReadTest() {
        log.info("Doing test.");
        Payment result=paymentDao.getPaymentById(1L);

        assert(result!=null);
        log.info(result.toString());
    }

    @After
    public void doAfterTest() {
        log.info("The test is over.");
    }
}
