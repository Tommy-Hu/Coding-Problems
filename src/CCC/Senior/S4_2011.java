package Senior;

import java.util.*;

public class S4_2011
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //These are all blood available
        int Om = sc.nextInt();
        int Op = sc.nextInt();
        int Am = sc.nextInt();
        int Ap = sc.nextInt();
        int Bm = sc.nextInt();
        int Bp = sc.nextInt();
        int ABm = sc.nextInt();
        int ABp = sc.nextInt();
        //These (with underscores) are patients
        int Om_ = sc.nextInt();
        int Op_ = sc.nextInt();
        int Am_ = sc.nextInt();
        int Ap_ = sc.nextInt();
        int Bm_ = sc.nextInt();
        int Bp_ = sc.nextInt();
        int ABm_ = sc.nextInt();
        int ABp_ = sc.nextInt();

        int patientsSatisfied = 0;

        //---------------------------------ONCE
        // O minus case:
        if (Om_ > Om)
        {
            //not enough om blood
            //that means only some of the om- patients are satisfied, and those are basically all the Om blood,
            // therefore all om- blood are all distributed in order to satisfy those patients
            patientsSatisfied += Om;
            Om_ -= Om;
            //the Om_ here are all the unsatisfied patients!
            Om = 0;
        }
        else
        {
            //enough om blood
            //that means all Om- patients are satisfied
            patientsSatisfied += Om_;
            //and some or all Om- blood are distributed to Om- patients, so subtract patient count from the total blood count
            Om -= Om_;
        }

        //---------------------------------TWICE
        // O plus case: note: some or all of the o minus blood are already distributed!
        if (Op_ > Op)
        {
            //more patients than the amount of blood
            //so not all patients are satisfied
            patientsSatisfied += Op;
            Op_ -= Op;
            //the rest of op_ patients are unsatisfied!
            Op = 0;
            //however, we can satisfy more of these patients giving them om blood.
            if (Op_ > Om)
            {
                //cannot satisfy all op_ patients with om blood left
                //but we can satisfy some or none of them
                //by giving them all the om blood left!
                patientsSatisfied += Om;
                Op_ -= Om;
                //the op_ are those that are still unsatisfied!
                Om = 0;
            }
            else
            {
                //can satisfy all op_ patients with the om blood left! So use some or all of those om blood and distribute them to op_ patients!
                patientsSatisfied += Op_;
                Om -= Op_;
                Op_ = 0;
            }
        }
        else
        {
            //enough op blood for all op patients
            //so all of them are satisfied!
            patientsSatisfied += Op_;
            //therefore, some amount of op blood would be used to satisfy those op patients
            Op -= Op_;
        }
        // A minus case: can use om, and some of them may be distributed!
        if (Am_ > Am)
        {
            //more patients than blood
            //not enough!
            //use all am blood for am_ patients!
            patientsSatisfied += Am;
            Am_ -= Am;
            Am = 0;
            //now am_ is the amount of patients unsatisfied still!
            //however, we can still satisfy them with om blood!
            if (Am_ > Om)
            {
                //cannot satisfy all those unsatisfied am_patients!
                //so use all the om blood to satisfy some of the patients!
                patientsSatisfied += Om;
                Am_ -= Om;
                //Am_ is the amount of patients still still still still still not satisfied!
                //AND ALL OF OM BLOOD IS USED AS WELL!!!!!!!!!!!!!!!!!!
                Om = 0;
            }
            else
            {
                //can satisfy all those unsatisfied am_ patients with om blood!
                patientsSatisfied += Am_;
                Om -= Am_;
                Am_ = 0;
            }
        }
        else
        {
            //enough blood for all patients!
            patientsSatisfied += Am_;
            Am -= Am_;
            Am_ = 0;
        }
        //B minus case: same as A minus case, except it's b-!
        if (Bm_ > Bm)
        {
            //more patients than blood
            //not enough!
            //use all am blood for am_ patients!
            patientsSatisfied += Bm;
            Bm_ -= Bm;
            Bm = 0;
            //now am_ is the amount of patients unsatisfied still!
            //however, we can still satisfy them with om blood!
            if (Bm_ > Om)
            {
                //cannot satisfy all those unsatisfied am_patients!
                //so use all the om blood to satisfy some of the patients!
                patientsSatisfied += Om;
                Bm_ -= Om;
                //Bm_ is the amount of patients still still still still still not satisfied!
                //AND ALL OF OM BLOOD IS USED AS WELL!!!!!!!!!!!!!!!!!!
                Om = 0;
            }
            else
            {
                //can satisfy all those unsatisfied bm_ patients with om blood!
                patientsSatisfied += Bm_;
                Om -= Bm_;
                Bm_ = 0;
            }
        }
        else
        {
            //enough blood for all patients!
            patientsSatisfied += Bm_;
            Bm -= Bm_;
            Bm_ = 0;
        }

        //---------------------------------FOUR TIMES
        // A plus case:
        if (Ap_ > Ap)
        {
            //not enough ap blood for ap_ patients
            patientsSatisfied += Ap;
            //so use all ap blood for ap_ patients!
            Ap_ -= Ap;
            Ap = 0;
            //Ap_ are unsatisfied!
            //so check A minus for blood!
            if (Ap_ > Am)
            {
                //even a minus is not enough to satisfy the rest, so use up all a minus blood!
                patientsSatisfied += Am;
                Ap_ -= Am;
                Am = 0;
                //Ap_ are still unsatisfied!
                //so check O plus!
                if (Ap_ > Op)
                {
                    //Ap_ still not satisfied!
                    //so use up all op blood
                    patientsSatisfied += Op;
                    Ap_ -= Op;
                    Op = 0;
                    //at this point, still Ap_ is the unsatisfied group!
                    //so there's only one last chance: O minus
                    if (Ap_ > Om)
                    {
                        //the om blood cannot serve the rest of ap_ patients! what a mess!!!!!!
                        //so use up all om blood to serve the ap_ patients!
                        patientsSatisfied += Om;
                        Ap_ -= Om;
                        //still not satisfied are those ap_ patients!
                        Om = 0;
                    }
                    else
                    {
                        //the om blood can serve the rest of Ap_ patients!
                        patientsSatisfied += Ap_;
                        Om -= Ap_;
                        Ap_ = 0;
                    }
                }
                else
                {
                    //the still unsatisfied ap_ patients can be satisfied with o plus blood!
                    patientsSatisfied += Ap_;
                    Op -= Ap_;
                    Ap_ = 0;
                }
            }
            else
            {
                //enough to satisfy all ap patients with a minus blood!
                patientsSatisfied += Ap_;
                Am -= Ap_;
                Ap_ = 0;
            }
        }
        else
        {
            //enough ap blood for ap_ patients
            patientsSatisfied += Ap_;
            Ap -= Ap_;
            Ap_ = 0;
        }
        // B plus case:
        if (Bp_ > Bp)
        {
            //not enough ap blood for ap_ patients
            patientsSatisfied += Bp;
            //so use all ap blood for ap_ patients!
            Bp_ -= Bp;
            Bp = 0;
            //Bp_ are unsatisfied!
            //so check A minus for blood!
            if (Bp_ > Am)
            {
                //even a minus is not enough to satisfy the rest, so use up all a minus blood!
                patientsSatisfied += Am;
                Bp_ -= Am;
                Am = 0;
                //Bp_ are still unsatisfied!
                //so check O plus!
                if (Bp_ > Op)
                {
                    //Bp_ still not satisfied!
                    //so use up all op blood
                    patientsSatisfied += Op;
                    Bp_ -= Op;
                    Op = 0;
                    //at this point, still Bp_ is the unsatisfied group!
                    //so there's only one last chance: O minus
                    if (Bp_ > Om)
                    {
                        //the om blood cannot serve the rest of ap_ patients! what a mess!!!!!!
                        //so use up all om blood to serve the ap_ patients!
                        patientsSatisfied += Om;
                        Bp_ -= Om;
                        //still not satisfied are those ap_ patients!
                        Om = 0;
                    }
                    else
                    {
                        //the om blood can serve the rest of Bp_ patients!
                        patientsSatisfied += Bp_;
                        Om -= Bp_;
                        Bp_ = 0;
                    }
                }
                else
                {
                    //the still unsatisfied ap_ patients can be satisfied with o plus blood!
                    patientsSatisfied += Bp_;
                    Op -= Bp_;
                    Bp_ = 0;
                }
            }
            else
            {
                //enough to satisfy all ap patients with a minus blood!
                patientsSatisfied += Bp_;
                Am -= Bp_;
                Bp_ = 0;
            }
        }
        else
        {
            //enough ap blood for ap_ patients
            patientsSatisfied += Bp_;
            Bp -= Bp_;
            Bp_ = 0;
        }
        // AB minus case:
        if (ABm_ > ABm)
        {
            //not enough ap blood for ap_ patients
            patientsSatisfied += ABm;
            //so use all ap blood for ap_ patients!
            ABm_ -= ABm;
            ABm = 0;
            //ABm_ are unsatisfied!
            //so check A minus for blood!
            if (ABm_ > Am)
            {
                //even a minus is not enough to satisfy the rest, so use up all a minus blood!
                patientsSatisfied += Am;
                ABm_ -= Am;
                Am = 0;
                //ABm_ are still unsatisfied!
                //so check B minus!
                if (ABm_ > Bm)
                {
                    //ABm_ still not satisfied!
                    //so use up all op blood
                    patientsSatisfied += Bm;
                    ABm_ -= Bm;
                    Bm = 0;
                    //at this point, still ABm_ is the unsatisfied group!
                    //so there's only one last chance: O minus
                    if (ABm_ > Om)
                    {
                        //the om blood cannot serve the rest of ap_ patients! what a mess!!!!!!
                        //so use up all om blood to serve the ap_ patients!
                        patientsSatisfied += Om;
                        ABm_ -= Om;
                        //still not satisfied are those ap_ patients!
                        Om = 0;
                    }
                    else
                    {
                        //the om blood can serve the rest of ABm_ patients!
                        patientsSatisfied += ABm_;
                        Om -= ABm_;
                        ABm_ = 0;
                    }
                }
                else
                {
                    //the still unsatisfied ap_ patients can be satisfied with o plus blood!
                    patientsSatisfied += ABm_;
                    Bm -= ABm_;
                    ABm_ = 0;
                }
            }
            else
            {
                //enough to satisfy all ap patients with a minus blood!
                patientsSatisfied += ABm_;
                Am -= ABm_;
                ABm_ = 0;
            }
        }
        else
        {
            //enough ap blood for ap_ patients
            patientsSatisfied += ABm_;
            ABm -= ABm_;
            ABm_ = 0;
        }

        //---------------------------------ALL THE TIMES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // AB plus case
        // Just check all the rest of the blood, and if the amount is greater than ab plus patients count, then all ab plus patients are satisfied; Or else,
        // only the total amount of blood left - ab plus patients count
        int left = Om + Op + Am + Ap + Bm + Bp + ABm + ABp;
        if (left >= ABp_)
        {
            patientsSatisfied += ABp_;
        }
        else
        {
            patientsSatisfied += left;
        }
        System.out.println(patientsSatisfied);
    }
}
