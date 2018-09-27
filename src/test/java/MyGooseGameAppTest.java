import net.sf.corn.httpclient.HttpForm;
import net.sf.corn.httpclient.HttpResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

    public class MyGooseGameAppTest {

        private ApplicationServer server = new ApplicationServer(4567, new MyGooseGameApp());

        @Before
        public void before() throws Exception {
            server.start();
        }

        @After
        public void after() throws Exception {
            server.stop();
        }

        @Test
        public void shouldCallPost() throws URISyntaxException, IOException {
            HttpForm form = new HttpForm(new URI("http://localhost:4567/players/add"));
            form.putFieldValue("name", "Pippo");

            HttpResponse response = form.doPost();

            assertThat(response.getData(), is("players: Pippo"));
        }

        @Test
        public void shouldCallGet() throws Exception {

            String player = "Pippo";
            HttpForm form = new HttpForm(new URI("http://localhost:4567/players/" + player + "/rolls"));

            form.putFieldValue("dice1", "2");
            form.putFieldValue("dice2", "3");

            HttpResponse response = form.doGet();

            assertThat(response.getData(), is("Pippo rolls 2, 3. Pippo moves from 6 to 11"));
        }

        @Test
        public void shouldBeEmpty() throws Exception {
            HttpForm form = new HttpForm(new URI("http://localhost:4567/list"));
            HttpResponse response = form.doGet();

            assertThat(response.getData(), is("empty"));
        }

        private void putName(String name) throws URISyntaxException, IOException {
            HttpForm form = new HttpForm(new URI("http://localhost:4567/add-name"));
            form.putFieldValue("name", name);
            form.putFieldValue("name", name);
            form.doPost();
        }
    }
