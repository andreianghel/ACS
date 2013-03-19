public class EncrypterFactory 
{
	public Encrypter get()
	{
		class FuncEncryp implements Encrypter
		{
				private String sir = "";
			
				public String encrypt(String s)
				{
					char[] sirchar = s.toCharArray();
					
					for(int i = 0; i < s.length(); i++){
						sirchar[i] -= 5;
						sir += sirchar[i];
					}
					return sir;
				}

			
				public String decrypt(String s) 
				{
					char[] sirchar = s.toCharArray();
					
					for(int i = 0; i < s.length(); i++)
					{
						sirchar[i] += 5;
						sir += sirchar[i];
					}
					return sir;
				}
			
				public String getSir()
				{
					return sir;
				}
		}
		return new FuncEncryp();
	}
}