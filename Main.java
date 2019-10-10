class Main{

	static String man="Programme de production de mots de Christoffel\nEntrees possibles:\n\t-\"int int\"\n\t-\"int,int\"\n\t-\"(int,int)\"";

	static String chris(int a, int b){
		int x0=0;
		int x1=1;
		String w="";
		while(x1 != 0){
			x1=(x0+a) % (a+b);
			if(x1>=x0)
				w+="x";
			else
				w+="y";
			x0=x1;

		}
		return w;
	}

	public static void main(String [] args){
		String s="";
		if(args.length == 1){
			s=args[0];
			if(s.equals("?")||s.equals("help")){
				System.out.println(man);
				return;
			}
			char c;
			int j=0;
			int k=s.length();

			if(s.charAt(0) == '(' && s.charAt(k-1) == ')'){
				j++; k--;
			}

			String s0="";	
			String s1="";
			boolean bool=false;
			
			for(int i=j; i<k; i++){
				if(s.charAt(i)== ',' ){
					bool=true;
					i++;
				}
				if(!bool)
					s0+=s.charAt(i);
				else
					s1+=s.charAt(i);
			}

			if(s1.length()==0){
				System.out.println("Erreur: Entree de type invalide");
				return;
			}
			try{
				int a=Integer.parseInt(s0);
				int b=Integer.parseInt(s1);
				s=chris(a,b); 
			}catch(Exception e){
				s="Erreur: Entree de type invalide";
			}

		} else
			if (args.length == 2){
				s=args[0];
				try{
				int a=Integer.parseInt(s);
				int b=Integer.parseInt(args[1]);
				s=chris(a,b); 
				}catch(Exception e){
					s="Erreur: Entree de type invalide";
				}
			} else s="Erreur: Entree de taille invalide";
		System.out.println(s);
		return;
	}


}