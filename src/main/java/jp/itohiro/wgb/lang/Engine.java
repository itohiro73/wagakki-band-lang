package jp.itohiro.wgb.lang;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

import java.io.IOException;

public class Engine {
    private int length;
    private static MutableList<Code> codes = Lists.mutable.empty();
    private static int index;
    private static char[] values;

    public Engine(String line){
        String remainder = line;
        while(!remainder.trim().isEmpty()) {
            for(Code code: Code.values()) {
                if (remainder.startsWith(code.op)) {
                    remainder = remainder.substring(code.op.length(), remainder.length());
                    codes.add(code);
                    break;
                }
            }
        }
        length = codes.size();
        values = new char[30000];
    }

    public void run() {
        int cp = 0;
        while(cp < length){
            Code code = codes.get(cp);
            cp = code.operate(cp);
            ++cp;
        }
        System.out.flush();
    }

    protected enum Code
    {
        GT(">"){
            @Override
            int operate(int cp) {
                index++;
                return cp;
            }
        },
        LD("<"){
            @Override
            int operate(int cp) {
                index--;
                return cp;
            }
        },
        PLUS("+"){
            @Override
            int operate(int cp) {
                values[index]++;
                return cp;
            }
        },
        MINUS("-"){
            @Override
            int operate(int cp) {
                values[index]--;
                return cp;
            }
        },
        DOT("."){
            @Override
            int operate(int cp) {
                System.out.write(values[index]);
                return cp;
            }
        },
        COMMA(","){
            @Override
            int operate(int cp) {
                try {
                    values[index] = (char)System.in.read();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return cp;
            }
        },
        START("["){
            @Override
            int operate(int cp) {
                if(values[index]==0){
                    int nest = 1;
                    while(nest > 0){
                        nest += codes.get(++cp).addStartNest();
                    }
                }
                return cp;
            }

            @Override
            int addStartNest() {
                return 1;
            }

            @Override
            int addEndNest() {
                return -1;
            }
        },
        END("]"){
            @Override
            int operate(int cp) {
                int nest = 1;
                while(nest > 0){
                    nest += codes.get(--cp).addEndNest();
                }
                return --cp;
            }

            @Override
            int addStartNest() {
                return -1;
            }

            @Override
            int addEndNest() {
                return 1;
            }
        };

        private final String op;

        Code(String op){

            this.op = op;
        }

        private String op(){
            return this.op;
        }

        abstract int operate(int cp);

        int addStartNest(){
            return 0;
        }

        int addEndNest(){
            return 0;
        }
    }
}
