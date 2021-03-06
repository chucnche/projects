USE [J3LP0001]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/28/2020 3:51:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[role] [varchar](10) NULL,
 CONSTRAINT [PK__user__F3DBC573B84F451F] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 3/28/2020 3:51:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[q_name] [nvarchar](max) NOT NULL,
	[date_created] [date] NULL,
	[ans_1] [nvarchar](100) NULL,
	[ans_2] [nvarchar](100) NULL,
	[ans_3] [nvarchar](100) NULL,
	[ans_4] [nvarchar](100) NULL,
	[true_answer] [varchar](100) NOT NULL,
	[created_by] [varchar](50) NULL,
 CONSTRAINT [PK__question__3213E83F6935E402] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[result]    Script Date: 3/28/2020 3:51:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[result](
	[username] [varchar](50) NULL,
	[score] [float] NULL,
	[numberQuestion] [int] NULL,
	[date_take] [varchar](50) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'cccc', N'ccc', N'c@gmail.com', N'student')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'ccccccccccc', N'ccccccccccc', N'congchuc719@gmail.com.vn', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chuc', N'chuc', N'chucnche@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chucbbbbb', N'12345', N'congchuc71@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chucbbbbbbbbbb', N'cccc', N'cong--chuc719@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chucbbbbbbbbbbbbbb', N'cccc', N'congchuc__719@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chucddddddd', N'chucnc', N'congchuc719@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chucnc', N'chucnc', N'chuccc@gmail.com', N'student')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chucnccccc', N'chuc', N'd@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'chucncccccccc', N'chuc', N'xxx@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'Congchuc0399', N'chuc', N'c@gmail.co', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'eeee', N'eeeee', N'congchuc_cccccc_719_@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'minh', N'minh', N'minhcv@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'minhnc', N'minhnc', N'oooo@gmail.com', N'teacher')
INSERT [dbo].[Account] ([username], [password], [email], [role]) VALUES (N'www', N'www', N'cong-chuc-719-@gmail.com', N'teacher')
SET IDENTITY_INSERT [dbo].[Question] ON 

INSERT [dbo].[Question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (2, N'1*2=?', CAST(N'2020-03-23' AS Date), N'0', N'2*1', N'2', N'3', N'23', N'chuc')
INSERT [dbo].[Question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (4, N'2*2=?', CAST(N'2020-03-23' AS Date), N'2', N'1', N'3', N'4', N'4', N'chuc')
INSERT [dbo].[Question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (6, N'3*3=?', CAST(N'2020-03-22' AS Date), N'4', N'7', N'9', N'8', N'3', N'minh')
INSERT [dbo].[Question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (9, N'6*6*6*6*6*6*0=?', CAST(N'2020-03-25' AS Date), N'1', N'2', N'3', N'0', N'4', N'minhnc')
INSERT [dbo].[Question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (10, N'1+1+1+1=?', CAST(N'2020-03-25' AS Date), N'2', N'3', N'4', N'5', N'3', N'minhnc')
INSERT [dbo].[Question] ([id], [q_name], [date_created], [ans_1], [ans_2], [ans_3], [ans_4], [true_answer], [created_by]) VALUES (11, N'1*1*6=?', CAST(N'2020-03-26' AS Date), N'1', N'3', N'4', N'6', N'4', N'chuc')
SET IDENTITY_INSERT [dbo].[Question] OFF
INSERT [dbo].[result] ([username], [score], [numberQuestion], [date_take]) VALUES (N'chucnc', 8, 5, N'2020-03-23')
INSERT [dbo].[result] ([username], [score], [numberQuestion], [date_take]) VALUES (N'chuc', 0, 1, N'2020-03-28')
ALTER TABLE [dbo].[Question]  WITH CHECK ADD  CONSTRAINT [FK_question_user] FOREIGN KEY([created_by])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[Question] CHECK CONSTRAINT [FK_question_user]
GO
ALTER TABLE [dbo].[result]  WITH CHECK ADD  CONSTRAINT [FK_result_user] FOREIGN KEY([username])
REFERENCES [dbo].[Account] ([username])
GO
ALTER TABLE [dbo].[result] CHECK CONSTRAINT [FK_result_user]
GO
