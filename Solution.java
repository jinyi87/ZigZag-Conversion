public class Solution
{
	public String convert(String s, int numRows)
	{
		int len = s.length();
		if (len < 2 || numRows < 2)
		{
			return s;
		}
		int m = 2 * (numRows - 1);// 每个锯齿的元素个数
		int n = len / m;// 完整锯齿的组数
		char[] str = new char[len];
		int k = 0;
		for (int i = 0; i < numRows; i++)
		{
			if (i == 0 || i == numRows - 1)
			{
				for (int j = 0;; j++)
				{
					if (i + j * m < len)
					{
						str[k++] = s.charAt(i + j * m);
					} else
					{
						break;
					}
				}
			} else
			{
				for (int j = 0;; j++)
				{

					if (j % 2 == 0)
					{
						if (i + j / 2 * m >= len)
							break;
						str[k++] = s.charAt(i + j / 2 * m);
					} else
					{
						if (2 * (j / 2 * m + numRows - 1) - (i + (j - 1) / 2 * m) >= len)
							break;
						str[k++] = s.charAt(2 * (j / 2 * m + numRows - 1) - (i + (j - 1) / 2 * m));
					}

				}
			}

		}
		return new String(str);
	}
}