import java.io.File;
import java.io.FileWriter;

class MapGenerator
{
	//MapGenerator v2.0 changed <CHANGES>
	
	public void generate()
	{
		System.out.println("started generating");
		String save = new String();
		
		int oberflaeche = 0, random = 0, treecounter = 0, flowercounter = 0, x = 0, y = 0, sky = 0, dirt = 1, deepdirt = 7, stone = 3, wood = 4, leave = 5, sand = 2, water = 8, sandstone = 9, gravel = 10, koal = 11, iron = 12, gold = 13, diamond = 14, lapislazuli = 15, redstone = 16, dungeon = 17, lava = 18, bedrock = 19, flower = 6;
		int[][] map = new int[100][1000];
		int randomy;
		
		boolean Dirt = true, Strand = false, Sand = false;
		
		for (int a = 0; a < 30; a ++)
		{
			for (int b = 0; b < 1000; b ++)
			{
				map[a][b] = sky;
			}
		}
		
		for (int a = 30; a < 100; a ++)
		{
			for (int b = 0; b < 1000; b ++)
			{
				map[a][b] = water;
			}
		}
		
		int summe = 0;
		
		for (oberflaeche = 0; oberflaeche < 1000; oberflaeche ++)
		{
			if (summe <= 15 && summe >= -15)
			{
				random = (int) (Math.random() * 5 - 2.5);
				summe += random;
			}
			
			else if (summe > 15)
			{
				random = (int) (Math.random() * 5 - 3);
				summe += random;
			}
			
			else if (summe < -15)
			{
				random = (int) (Math.random() * 5 + 3);
				summe += random;
			}
			
			if (summe <= 1)
			{
				map[20 + summe][oberflaeche] = dirt;
				treecounter ++;
				flowercounter ++;
				
				for (int a = 21 + summe; a < 100; a ++)
				{
					map[a][oberflaeche] = deepdirt;
				}
				
				Strand = false;
				Sand = false;
			}
			
			else if (summe > 1)
			{
				if (Strand == false)
				{
					if (Math.random() < 0.7)
					{
						Sand = true;
					}
					else
					{
						Sand = false;
					}
					
					Strand = true;
				}
				
				if (Strand == true)
				{
					if (Sand == true)
					{
						map[20 + summe][oberflaeche] = sand;
						map[21 + summe][oberflaeche] = sand;
						map[22 + summe][oberflaeche] = sand;
						
						for (int a = 23 + summe; a < 100; a ++)
						{
							map[a][oberflaeche] = sandstone;
						}
					}
					
					else if (Sand == false)
					{
						for (int a = 15 + summe; a < 100; a ++)
						{
							map[a][oberflaeche] = gravel;
						}
					}
				}
			}
			
			if (flowercounter == 4)
			{
				if (treecounter != 10)
				{
					int a = 0;
					
					for (a = 0; map[a][oberflaeche] != dirt; a ++)
					{
						
					}
					
					a --;
					
					if (map[a][oberflaeche] != water)
					{
						map[a][oberflaeche] = flower;
					}
				}
				
				flowercounter = 0;
			}
			
			if (treecounter == 10)
			{
				int a = 0;
				
				for (a = 0; map[a][oberflaeche] != dirt; a ++)
				{
					
				}
				
				a --;
				
				if (map[a][oberflaeche] != water && a > 9)
				{
					for (int b = 0; b < 5; b ++)
					{
						map[a - b][oberflaeche] = wood;
					}
					
					for (int b = 0; b < 3; b ++)
					{
						for (int c = 0; c < 5; c ++)
						{
							map[a - 5 + b][oberflaeche - 2 + c] = leave;
						}
					}
					
					for (int b = 0; b < 3; b ++)
					{
						map[a - 6][oberflaeche - 1 + b] = leave;
						map[a - 2][oberflaeche - 1 + b] = leave;
					}
					
				}
				
				treecounter = 0;
			}
		}
		
		summe = 0;
		
		for (oberflaeche = 0; oberflaeche < 1000; oberflaeche ++)
		{
			if (summe <= 10 && summe >= -10)
			{
				random = (int) (Math.random() * 7 - 3.5);
				summe += random;
			}
			
			else if (summe > 10)
			{
				random = (int) (Math.random() * 7 - 5.5);
				summe += random;
			}
			
			else if (summe < -10)
			{
				random = (int) (Math.random() * 7 - 1.5);
				summe += random;
			}
			
			for (int a = summe + 40; a < 100; a ++)
			{
				map[a][oberflaeche] = stone;
			}
		}
		
		random = (int) (Math.random() * 100 + 200);
		
		for (int a = 0; a < random; a ++)
		{
			x = (int) (Math.random() * 998 + 1);
			y = (int) (Math.random() * 49 + 50);

			map[y - 1][x - 1] = koal;
			map[y][x - 1] = koal;
			map[y + 1][x - 1] = koal;
			map[y - 1][x] = koal;
			map[y][x] = koal;
			map[y + 1][x] = koal;
			map[y - 1][x + 1] = koal;
			map[y][x + 1] = koal;
			map[y + 1][x + 1] = koal;
		}
		
		random = (int) (Math.random() * 40 + 80);
		
		for (int a = 0; a < random; a ++)
		{
			x = (int) (Math.random() * 998 + 1);
			y = (int) (Math.random() * 49 + 50);

			map[y - 1][x - 1] = iron;
			map[y][x - 1] = iron;
			map[y - 1][x] = iron;
			map[y][x] = iron;
		}
		
		random = (int) (Math.random() * 40 + 60);
		
		for (int a = 0; a < random; a ++)
		{
			x = (int) (Math.random() * 998 + 1);
			y = (int) (Math.random() * 39 + 60);

			map[y - 1][x - 1] = gold;
			map[y][x - 1] = gold;
			map[y - 1][x] = gold;
			map[y][x] = gold;
		}
		
		random = (int) (Math.random() * 40 + 80);
		
		for (int a = 0; a < random; a ++)
		{
			x = (int) (Math.random() * 998 + 1);
			y = (int) (Math.random() * 49 + 50);

			map[y - 1][x - 1] = lapislazuli;
			map[y][x - 1] = lapislazuli;
			map[y - 1][x] = lapislazuli;
			map[y][x] = lapislazuli;
		}
		
		random = (int) (Math.random() * 30 + 50);
		
		for (int a = 0; a < random; a ++)
		{
			x = (int) (Math.random() * 998 + 1);
			y = (int) (Math.random() * 14 + 85);

			map[y - 1][x - 1] = diamond;
			map[y][x - 1] = diamond;
			map[y - 1][x] = diamond;
			map[y][x] = diamond;
		}
		
		random = (int) (Math.random() * 40 + 80);
		
		for (int a = 0; a < random; a ++)
		{
			x = (int) (Math.random() * 998 + 1);
			y = (int) (Math.random() * 49 + 50);

			map[y - 1][x - 1] = redstone;
			map[y][x - 1] = redstone;
			map[y - 1][x] = redstone;
			map[y][x] = redstone;
		}
		
		random = (int) (Math.random() * 20 + 10);
		
		for (int a = 0; a < random; a ++)
		{
			random = (int) (Math.random() * 5 + 10);
			randomy = (int) (Math.random() * 7 + 3);
			
			x = (int) (Math.random() * 1000 - random - 1);
			y = (int) (Math.random() * 36 - randomy + 50);
			
			for (int b = 0; b < randomy; b ++)
			{
				for (int c = 0; c < random; c ++)
				{
					map[y + b][x + c] = dungeon;
				}
			}
			for(int b = 1; b < randomy - 1; b++)
			{
				map[y + b][x - 1] = dungeon;
				map[y + b][x + random] = dungeon;
			}
			
			
			if (Math.random() > 0.80)
			{
				for (int b = 2; b < random - 2; b ++)
				{
					map[y + randomy][x + b] = lava;
				}
			}
		}
		
		for (int a = 0; a < 1000; a ++)
		{
			
			map[99][a] = bedrock;
		}
		
		for (int a = 0; a < 100; a ++)
		{
			map[a][0] = bedrock;
			map[a][999] = bedrock;
		}
		
		for (int a = 0; a < 100; a ++)
		{
			for (int b = 0; b < 1000; b ++)
			{
				save = save + String.valueOf(map[a][b]) + " ";
			}
			
			save = save + ("-1" + "\n");
		}
		
		System.out.println("write");
		
		try {
			
			FileWriter pw = new FileWriter(new File("C:\\CrineMaft\\map.txt"));
			
			pw.write(save);
			
			pw.close();
			
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("complete.");
	}
	
	public static void main(String[] args)
	{
		MapGenerator m = new MapGenerator();
		m.generate();
	}
}