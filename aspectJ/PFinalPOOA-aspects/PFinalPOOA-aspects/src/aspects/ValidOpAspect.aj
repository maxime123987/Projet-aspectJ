package aspects;

import client.Operation;

public aspect ValidOpAspect {
    boolean around(Operation op,Operation funcOp):execution(boolean client.Operation.isOperationValid(Operation)) && target(op) && args(funcOp){
        if (funcOp == null) {
            System.out.println("Opération invalide! Veuillez réessayer...");
            return false;
        }

        if (!(op.getCompte().getSolde() >= funcOp.getCompte().getSolde())) {
            System.out.println("Solde insuffisant!");
            return false;
        }

        System.out.println("Opération de "+op.getClass().getSimpleName()+" validée.");
        return true;

    }

}
