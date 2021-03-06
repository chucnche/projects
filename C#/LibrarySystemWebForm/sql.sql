USE [Library]
GO
/****** Object:  Table [dbo].[Book]    Script Date: 4/21/2020 7:41:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[bookNumber] [int] IDENTITY(1,1) NOT NULL,
	[title] [nvarchar](50) NULL,
	[authors] [nvarchar](50) NULL,
	[publisher] [nvarchar](50) NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[bookNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Borrower]    Script Date: 4/21/2020 7:41:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Borrower](
	[borrowerNumber] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NULL,
	[sex] [char](1) NULL,
	[address] [nvarchar](50) NULL,
	[telephone] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_Borrower] PRIMARY KEY CLUSTERED 
(
	[borrowerNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CirculatedCopy]    Script Date: 4/21/2020 7:41:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CirculatedCopy](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[copyNumber] [int] NOT NULL,
	[borrowerNumber] [int] NOT NULL,
	[borrowedDate] [datetime] NOT NULL,
	[dueDate] [datetime] NULL,
	[returnedDate] [datetime] NULL,
	[fineAmount] [float] NULL,
 CONSTRAINT [PK_CirculatedCopy] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Copy]    Script Date: 4/21/2020 7:41:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Copy](
	[copyNumber] [int] IDENTITY(1,1) NOT NULL,
	[bookNumber] [int] NOT NULL,
	[sequenceNumber] [int] NOT NULL,
	[type] [char](1) NULL,
	[price] [float] NULL,
 CONSTRAINT [PK_Copy] PRIMARY KEY CLUSTERED 
(
	[copyNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reservation]    Script Date: 4/21/2020 7:41:00 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reservation](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[borrowerNumber] [int] NOT NULL,
	[bookNumber] [int] NOT NULL,
	[date] [datetime] NOT NULL,
	[status] [char](1) NULL,
 CONSTRAINT [PK_Reservation] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Book] ON 

INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (1, N'tttttttttttt', N'uuuuuuuuuuuu', N'0000000000')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (2, N'333333', N'gggggggggg', N'jjjjjjjjj')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (3, N'66666666666', N'asssssssssssssss', N'yyyyyyyyyyyyy')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (6, N'eeeeeeeee', N'eeee', N'tttttttttt')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (7, N'', N'', N'p7')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (8, N't8', N'a8', N'p8')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (9, N't9', N'', N'')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (10, N'Test', N'Andrew', N'Pubg')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (11, N't22', N'a22', N'p22')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (12, N't22', N'a22', N'p22')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (13, N'aa', N'aa', N'aa')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (14, N'', N'aa', N'aa')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (16, N'aaa', N'aa', N'aa')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (17, N'ddđ', N'dddddd', N'dddddd')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (18, N'ssssssss', N'ssssssssss', N'ssssssssssss')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (19, N'sss', N'sss', N'sss')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (20, N'ee', N'ee', N'ee')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (21, N'sss', N'1111', N'11111111111')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (35, N'ee', N'ee', N'ee')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (36, N'dd', N'dd', N'dd')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (37, N'ffff', N'fff', N'ffff')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (38, N'rrrrrrrrrrrr', N'rrrrrrrrrrrrrrr', N'rrr')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (39, N'ee', N'ee', N'ee')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (40, N'ee', N'ee', N'ee')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (41, N'dd', N'dd', N'dd')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (45, N'aaaaaaaa', N'dddd', N'dddd')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (46, N'aaaaaaaa', N'aaaaaaaa', N'aaaaaaaa')
INSERT [dbo].[Book] ([bookNumber], [title], [authors], [publisher]) VALUES (47, N'dđ', N'ddddđ', N'dddddddddddđ')
SET IDENTITY_INSERT [dbo].[Book] OFF
SET IDENTITY_INSERT [dbo].[Borrower] ON 

INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (1, N'Huong', N'F', N'ffff', N'fffffff', N'ffffffffff')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (2, N'Kien', N'M', N'a2', N't2', N'e2')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (3, N'', N'F', N'', N'', N'')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (4, N' ', N'F', N' ', N' ', N' ')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (6, N'', N'A', N'', N'', N'')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (7, N'', N'M', N'aaaaaaa', N'', N'')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (8, N'', N'M', N'', N'', N'')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (9, N'', N'M', N'', N'', N'')
INSERT [dbo].[Borrower] ([borrowerNumber], [name], [sex], [address], [telephone], [email]) VALUES (10, N'', N'd', N'dđdd', N'dđ', N'ddd')
SET IDENTITY_INSERT [dbo].[Borrower] OFF
SET IDENTITY_INSERT [dbo].[CirculatedCopy] ON 

INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (8, 1, 1, CAST(N'2013-10-02T00:00:00.000' AS DateTime), CAST(N'2013-10-16T00:00:00.000' AS DateTime), CAST(N'2020-04-03T00:00:00.000' AS DateTime), 2361)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (9, 1, 1, CAST(N'2013-10-02T00:00:00.000' AS DateTime), CAST(N'2013-10-16T00:00:00.000' AS DateTime), CAST(N'2013-10-23T00:00:00.000' AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (10, 2, 1, CAST(N'2013-10-02T00:00:00.000' AS DateTime), CAST(N'2013-10-16T00:00:00.000' AS DateTime), CAST(N'2013-10-22T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (11, 2, 3, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (12, 4, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-23T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (13, 5, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-23T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (14, 4, 2, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2020-03-29T00:00:00.000' AS DateTime), 2355)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (15, 1, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-23T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (16, 1, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-23T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (17, 7, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (18, 9, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2020-04-03T00:00:00.000' AS DateTime), 2360)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (19, 10, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (20, 12, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (21, 13, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-23T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (22, 1, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), CAST(N'2013-10-17T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (23, 3, 1, CAST(N'2013-10-04T00:00:00.000' AS DateTime), CAST(N'2013-10-18T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (24, 1, 1, CAST(N'2013-10-05T00:00:00.000' AS DateTime), CAST(N'2013-10-19T00:00:00.000' AS DateTime), CAST(N'2013-10-25T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (25, 3, 1, CAST(N'2013-10-05T00:00:00.000' AS DateTime), CAST(N'2013-10-19T00:00:00.000' AS DateTime), CAST(N'2013-10-25T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (26, 7, 1, CAST(N'2013-10-05T00:00:00.000' AS DateTime), CAST(N'2013-10-19T00:00:00.000' AS DateTime), CAST(N'2013-10-20T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (27, 8, 1, CAST(N'2013-10-05T00:00:00.000' AS DateTime), CAST(N'2013-10-19T00:00:00.000' AS DateTime), CAST(N'2013-10-10T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (28, 9, 1, CAST(N'2013-10-05T00:00:00.000' AS DateTime), CAST(N'2013-10-19T00:00:00.000' AS DateTime), CAST(N'2013-10-25T00:00:00.000' AS DateTime), 6)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (29, 9, 1, CAST(N'2013-10-05T00:00:00.000' AS DateTime), CAST(N'2013-10-19T00:00:00.000' AS DateTime), CAST(N'2020-04-02T00:00:00.000' AS DateTime), 2357)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (30, 10, 1, CAST(N'2013-10-10T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), CAST(N'2013-10-10T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (31, 13, 1, CAST(N'2013-10-10T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), CAST(N'2013-10-10T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (32, 15, 2, CAST(N'2013-10-10T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), CAST(N'2020-04-03T00:00:00.000' AS DateTime), 2353)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (33, 17, 2, CAST(N'2013-10-10T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (34, 19, 2, CAST(N'2013-10-10T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (35, 3, 3, CAST(N'2013-10-20T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (36, 12, 3, CAST(N'2013-10-20T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (37, 13, 3, CAST(N'2013-10-20T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (38, 18, 3, CAST(N'2013-10-20T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (39, 20, 1, CAST(N'2013-10-10T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), CAST(N'2020-03-29T00:00:00.000' AS DateTime), 2348)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (40, 26, 1, CAST(N'2013-10-20T00:00:00.000' AS DateTime), CAST(N'2013-11-03T00:00:00.000' AS DateTime), CAST(N'2013-10-10T00:00:00.000' AS DateTime), 0)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (41, 27, 1, CAST(N'2013-10-20T00:00:00.000' AS DateTime), CAST(N'2013-11-03T00:00:00.000' AS DateTime), CAST(N'2020-03-30T00:00:00.000' AS DateTime), 2339)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (42, 26, 4, CAST(N'2013-10-10T00:00:00.000' AS DateTime), CAST(N'2013-10-24T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (43, 9, 1, CAST(N'2013-10-20T00:00:00.000' AS DateTime), CAST(N'2013-11-03T00:00:00.000' AS DateTime), CAST(N'2020-03-30T00:00:00.000' AS DateTime), 2339)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (44, 13, 2, CAST(N'2020-03-12T00:00:00.000' AS DateTime), CAST(N'2020-03-26T00:00:00.000' AS DateTime), CAST(N'2020-04-02T00:00:00.000' AS DateTime), 7)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (45, 1, 4, CAST(N'2020-03-14T00:00:00.000' AS DateTime), CAST(N'2020-03-28T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (46, 9, 1, CAST(N'2020-03-30T00:00:00.000' AS DateTime), CAST(N'2020-04-12T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (47, 4, 1, CAST(N'2020-03-30T00:00:00.000' AS DateTime), CAST(N'2020-04-13T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (48, 4, 1, CAST(N'2020-03-30T00:00:00.000' AS DateTime), CAST(N'2020-04-13T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (49, 4, 1, CAST(N'2020-03-30T00:00:00.000' AS DateTime), CAST(N'2020-04-13T00:00:00.000' AS DateTime), NULL, NULL)
INSERT [dbo].[CirculatedCopy] ([ID], [copyNumber], [borrowerNumber], [borrowedDate], [dueDate], [returnedDate], [fineAmount]) VALUES (50, 9, 2, CAST(N'2020-03-29T00:00:00.000' AS DateTime), CAST(N'2020-04-12T00:00:00.000' AS DateTime), CAST(N'2020-03-30T00:00:00.000' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[CirculatedCopy] OFF
SET IDENTITY_INSERT [dbo].[Copy] ON 

INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (1, 2, 1, N'B', 10)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (2, 2, 2, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (3, 2, 3, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (4, 1, 1, N'B', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (5, 1, 2, N'B', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (7, 2, 5, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (8, 2, 6, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (9, 2, 7, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (10, 2, 8, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (12, 6, 1, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (13, 6, 2, N'A', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (14, 3, 1, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (15, 3, 2, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (17, 2, 9, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (18, 2, 1, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (19, 2, 2, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (20, 2, 2, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (23, 3, 1, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (26, 9, 1, N'B', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (27, 9, 2, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (28, 7, 1, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (29, 1, 5, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (30, 1, 6, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (31, 1, 7, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (32, 1, 8, N'A', 0)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (33, 1, 9, N'A', 1111)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (34, 1, 10, N'A', 111)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (35, 1, 11, N'R', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (36, 1, 12, N'R', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (37, 1, 13, N'R', 100)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (38, 1, 14, N'A', 333)
INSERT [dbo].[Copy] ([copyNumber], [bookNumber], [sequenceNumber], [type], [price]) VALUES (39, 1, 15, N'R', 0)
SET IDENTITY_INSERT [dbo].[Copy] OFF
SET IDENTITY_INSERT [dbo].[Reservation] ON 

INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (10, 2, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (12, 1, 1, CAST(N'2013-10-03T00:00:00.000' AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (16, 4, 9, CAST(N'2013-10-10T00:00:00.000' AS DateTime), N'A')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (20, 2, 9, CAST(N'2020-03-14T00:00:00.000' AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (21, 4, 9, CAST(N'2020-03-14T00:00:00.000' AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (22, 6, 9, CAST(N'2020-03-29T00:00:00.000' AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (23, 6, 9, CAST(N'2020-03-29T00:00:00.000' AS DateTime), N'R')
INSERT [dbo].[Reservation] ([ID], [borrowerNumber], [bookNumber], [date], [status]) VALUES (24, 6, 9, CAST(N'2020-03-29T00:00:00.000' AS DateTime), N'R')
SET IDENTITY_INSERT [dbo].[Reservation] OFF
ALTER TABLE [dbo].[CirculatedCopy]  WITH CHECK ADD  CONSTRAINT [FK_CirculatedCopy_Borrower] FOREIGN KEY([borrowerNumber])
REFERENCES [dbo].[Borrower] ([borrowerNumber])
GO
ALTER TABLE [dbo].[CirculatedCopy] CHECK CONSTRAINT [FK_CirculatedCopy_Borrower]
GO
ALTER TABLE [dbo].[CirculatedCopy]  WITH CHECK ADD  CONSTRAINT [FK_CirculatedCopy_Copy] FOREIGN KEY([copyNumber])
REFERENCES [dbo].[Copy] ([copyNumber])
GO
ALTER TABLE [dbo].[CirculatedCopy] CHECK CONSTRAINT [FK_CirculatedCopy_Copy]
GO
ALTER TABLE [dbo].[Copy]  WITH CHECK ADD  CONSTRAINT [FK_Copy_Book] FOREIGN KEY([bookNumber])
REFERENCES [dbo].[Book] ([bookNumber])
GO
ALTER TABLE [dbo].[Copy] CHECK CONSTRAINT [FK_Copy_Book]
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD  CONSTRAINT [FK_Reservation_Book] FOREIGN KEY([bookNumber])
REFERENCES [dbo].[Book] ([bookNumber])
GO
ALTER TABLE [dbo].[Reservation] CHECK CONSTRAINT [FK_Reservation_Book]
GO
ALTER TABLE [dbo].[Reservation]  WITH CHECK ADD  CONSTRAINT [FK_Reservation_Borrower] FOREIGN KEY([borrowerNumber])
REFERENCES [dbo].[Borrower] ([borrowerNumber])
GO
ALTER TABLE [dbo].[Reservation] CHECK CONSTRAINT [FK_Reservation_Borrower]
GO
