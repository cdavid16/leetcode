class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new LinkedList<>();
        if(n<=1){
            combinations.add(n==0?"":"()");
        }
        else {
            int levels = n*2;
            node tree = new node(levels, 40, 1, 0, "(", levels);
            explore(tree, combinations);
            System.out.println("Test");

        }

        return combinations;
    }

    private void explore(node nd, List<String> list){
        if(nd==null)
            return;

        if(nd.level > 1){
            explore(nd.child1, list);
            explore(nd.child2, list);
        }

        if(nd.isValid() && nd.level==1)
            list.add(nd.current);


    }


    class node{
        private node child1, child2;
        int level = 0, ascii, opened, closed;
        String current;
        public node(int level, int ascii, int opened, int closed, String current, int levels){ //40 -> (  ; 41 -> )
            this.ascii = ascii;
            this.closed = closed;
            this.opened = opened;
            this.level = level;
            this.current = current;
            if(this.level > 0 ){
                if(opened<=levels/2)
                    this.child1 = new node(this.level-1, 40, opened+1, closed, current+"(", levels);

                if(closed<=levels/2)
                    this.child2 = new node(this.level-1, 41, opened, closed+1, current+")", levels);

            }
        }

        public boolean isValid() {
            //String s
            if(this.current.length()%2!=0)
                return false;

            if(this.current.length()==0)
                return true;

            Stack<Integer> stack = new Stack<>();
            stack.push((int)this.current.charAt(0));
            for(int i = 1; i<this.current.length(); i++){
                int ascii =(int)this.current.charAt(i);
                int diff = ascii - (stack.size()>0?stack.peek():0);



                if(diff >= 1 && diff <=3)
                    stack.pop();
                else
                    stack.add(ascii);
            }

            return stack.size()==0;
        }
    }
}
