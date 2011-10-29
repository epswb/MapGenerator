import java.io.File;
import java.io.FileWriter;

class MapGenerator
{
	public void generate()
	{
		System.out.println("started generating");
		String save = new String();
		
		int oberfläche = 0, random = 0, treecounter = 0, flowercounter = 0, x = 0, y = 0, sky = 1, dirt = 2, deepdirt = 8, stone = 4, wood = 5, leave = 6, sand = 3, water = 9, sandstone = 10, gravel = 11, koal = 12, iron = 13, gold = 14, diamond = 15, lapislazuli = 16, redstone = 17, dungeon = 18, lava = 19, bedrock = 20, flower = 7;
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
		
		for (oberfläche = 0; oberfläche < 1000; oberfläche ++)
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
				map[20 + summe][oberfläche] = dirt;
				treecounter ++;
				flowercounter ++;
				
				for (int a = 21 + summe; a < 100; a ++)
				{
					map[a][oberfläche] = deepdirt;
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
						map[20 + summe][oberfläche] = sand;
						map[21 + summe][oberfläche] = sand;
						map[22 + summe][oberfläche] = sand;
						
						for (int a = 23 + summe; a < 100; a ++)
						{
							map[a][oberfläche] = sandstone;
						}
					}
					
					else if (Sand == false)
					{
						for (int a = 15 + summe; a < 100; a ++)
						{
							map[a][oberfläche] = gravel;
						}
					}
				}
			}
			
			if (flowercounter == 4)
			{
				if (treecounter != 10)
				{
					int a = 0;
					
					for (a = 0; map[a][oberfläche] != dirt; a ++)
					{
						
					}
					
					a --;
					
					if (map[a][oberfläche] != water)
					{
						map[a][oberfläche] = flower;
					}
				}
				
				flowercounter = 0;
			}
			
			if (treecounter == 10)
			{
				int a = 0;
				
				for (a = 0; map[a][oberfläche] != dirt; a ++)
				{
					
				}
				
				a --;
				
				if (map[a][oberfläche] != water && a > 9)
				{
					for (int b = 0; b < 5; b ++)
					{
						map[a - b][oberfläche] = wood;
					}
					
					for (int b = 0; b < 3; b ++)
					{
						for (int c = 0; c < 5; c ++)
						{
							map[a - 5 + b][oberfläche - 2 + c] = leave;
						}
					}
					
					for (int b = 0; b < 3; b ++)
					{
						map[a - 6][oberfläche - 1 + b] = leave;
						map[a - 2][oberfläche - 1 + b] = leave;
					}
					
				}
				
				treecounter = 0;
			}
		}
		
		summe = 0;
		
		for (oberfläche = 0; oberfläche < 1000; oberfläche ++)
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
				map[a][oberfläche] = stone;
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
			
			save = save + ("0" + "\n");
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