package concurrent.concurrentArt;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author: long
 * @create: 2023-02-23 15:41
 * @Description
 **/

public class QuickEmailToWikiExtractor {

    private ThreadPoolExecutor threadPoolExecutor;

    private BlockingQueue<EmailDTO> emailQueue;

    public QuickEmailToWikiExtractor(){
        emailQueue = new LinkedBlockingQueue<EmailDTO>();
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,corePoolSize,101,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>(2000));
    }

    private void insertToWiki() throws InterruptedException {
        while (true){
            EmailDTO email = emailQueue.poll(2, TimeUnit.SECONDS);
            if (email == null){
                break;
            }
            threadPoolExecutor.submit(new insertToWikiTask(email));
        }
    }

    protected List<Article> extraEmail(){
        List<EmailDTO> allEmails = getEmail();
        for (EmailDTO a:allEmails) {
            emailQueue.offer(a);
        }
        return null;
    }

    private List<EmailDTO> getEmail() {
        return null;
    }


}
