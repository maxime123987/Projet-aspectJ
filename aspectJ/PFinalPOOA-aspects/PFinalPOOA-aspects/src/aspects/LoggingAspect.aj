package aspects;

import client.SimulationBancaire;
import client.Operation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public aspect LoggingAspect {
    private static File log;

    before():execution(static void client.SimulationBancaire.main(String[])){
        initLogFile();
    }

    private void initLogFile() {
        SimpleDateFormat date = new SimpleDateFormat("ddMMyy-HHmmss");
        File dir = new File("LOGS/");

        if(!dir.exists())
            dir.mkdir();

        log = new File("LOGS/log"+date.format(new Date())+".txt");

        try{
            if(!log.createNewFile())
                log = null;
        }catch(IOException e){
            e.printStackTrace();
        }

        if(log != null){
            try{
                FileWriter fw = new FileWriter(log);
                fw.write("SESSION DU "+date.format(new Date())+"\n\n");
                fw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    after(Operation op, float montant):execution(void client.Operation.executer(float)) && target(op) && args(montant){
        writeToFile(op.toString()+"\n"+"Montant: "+montant+"\n\n");
    }

    private void writeToFile(String txt) {
        if(log != null){
            try{
                FileWriter fw = new FileWriter(log, true);
                fw.write(txt);
                fw.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

}
