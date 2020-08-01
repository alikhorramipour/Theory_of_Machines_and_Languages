/*
 * NFA to DFA converter
 * Ali Khorramipour - 9631407
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class ConverterNFAtoDFA {
    
    private NFA source;
    private DFA target;
    private List<List<String>> toDo;
    private List<List<String>> newLine;
    private State startState;
    Map< List<String>, Map<String,List<String>>> tempTransitions;
    List<List<State>> lignes;
    List<List<State>> cells;
 
    public ConverterNFAtoDFA() {
    }
    
    
    public ConverterNFAtoDFA(NFA nfa){
    this.source = nfa;
    this.startState = nfa.getStartState();
    tempTransitions = new HashMap<>();
    toDo = new ArrayList<>();
    lignes = new ArrayList<>();
    cells = new ArrayList<>();
    newLine = new ArrayList<>();
    }


    public void generateTempDFA(){
        
        List<State> l = new ArrayList();
        
        l.add(startState);
        toDo.add(statesToString(l));
        newLine.add(statesToString(l));
        
        List<String> currStates = toDo.get(0);
        
        boolean isRepeated = false;
        Integer countCells = 0;
            
        mainLoop :
       do{
                Map<String, List<String>> map = new HashMap<>();
                currStates = toDo.get(0);
                for (String letter : source.alphabet) {
                    List<String> aCellString = new ArrayList<>();
                    for(String s : currStates){
                        if(!s.equals("Empty")){
                        for(String str : source.getTransitions().get(s).get(letter)){
                            aCellString.add(str);
                        }
                        }}
                    removeDuplicates(aCellString);
                    map.put(letter, aCellString);
                    tempTransitions.put(currStates, map);
                    
                        if(tempTransitions.containsKey(aCellString)){
                        }
                        else{newLine.add(aCellString);
                        toDo.add(aCellString);
                        }
                    }
                toDo.remove(currStates);
                for(List<String> key : tempTransitions.keySet()){
                    boolean b = true;
                    for(String str : source.alphabet){
                        for(String strin : source.alphabet){
                            if(!tempTransitions.get(currStates).get(strin).equals(tempTransitions.get(key).get(str))){
                                 b = false;
                            }
                        }
                     }
                    if(b){
                    break mainLoop;}
                   }      
            }     while(!toDo.isEmpty());        
    }


    public void printTempTransitions(){ 
        
        for(List<String> s : tempTransitions.keySet()){         
                for(String letter : source.alphabet){
                    System.out.print("");
                    System.out.print(s);
                    System.out.print(" ");
                
                    System.out.print(" + ");
                    System.out.print(letter);
                    System.out.print("   :  ");
                    
                    System.out.print(tempTransitions.get(s));
                  
                    System.out.print("\n");
                }
            System.out.print("\n");}
    }
        
        
        
 
    public State getState(State[] list, String name){
         State st = null;
         for(State s : list){
         
             if(s.getName().equals(name)){
               st = s;
             }
                 
         }
    return st;
    }
    
    public List<String> statesToString(List<State> l){
        List<String> list = new ArrayList<>();
        for(State s : l){
           list.add(s.getName());
        }
    return list;
    }
    
    
    
    public void removeDuplicates(List<String> list){
        HashSet hs = new HashSet();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);}
}

/*
 * Output (after entering in DFA):
 *      q0,01101:q2
 *      q0,10:invalid
 *      q0,101:invalid
 */
