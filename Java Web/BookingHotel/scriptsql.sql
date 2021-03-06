USE [BookingHotel]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/6/2020 1:15:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Nickname] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Dob] [date] NOT NULL,
	[CMND] [int] NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[Phone] [int] NOT NULL,
	[Job] [nvarchar](50) NOT NULL,
	[Gender] [bit] NOT NULL,
	[Type] [int] NOT NULL,
	[Money] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Username] [nvarchar](50) NOT NULL,
	[RID] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[FID] [nvarchar](50) NOT NULL,
	[Checkin] [date] NOT NULL,
	[Checkout] [date] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FormOfRent]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FormOfRent](
	[FID] [nvarchar](50) NOT NULL,
	[Form] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_FormOfRent] PRIMARY KEY CLUSTERED 
(
	[FID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[History]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[History](
	[HID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Roomnumber] [nvarchar](50) NOT NULL,
	[Form] [nvarchar](50) NOT NULL,
	[Checkin] [date] NOT NULL,
	[Checkout] [date] NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK_History] PRIMARY KEY CLUSTERED 
(
	[HID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Invoice]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Invoice](
	[Username] [nvarchar](50) NOT NULL,
	[RID] [nvarchar](50) NOT NULL,
	[SID] [nvarchar](50) NOT NULL,
	[InvoiceDate] [date] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KindOfRoom]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KindOfRoom](
	[KID] [nvarchar](50) NOT NULL,
	[Kind] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_KindOfRoom] PRIMARY KEY CLUSTERED 
(
	[KID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PriceOfForm]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PriceOfForm](
	[PID] [nvarchar](50) NOT NULL,
	[KID] [nvarchar](50) NOT NULL,
	[FID] [nvarchar](50) NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK_PriceOfForm] PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[RID] [nvarchar](50) NOT NULL,
	[Roomnumber] [nvarchar](50) NOT NULL,
	[KID] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[RID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Service]    Script Date: 3/6/2020 1:15:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Service](
	[SID] [nvarchar](50) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Price] [int] NOT NULL,
 CONSTRAINT [PK_Service] PRIMARY KEY CLUSTERED 
(
	[SID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([Username], [Password], [Nickname], [Name], [Dob], [CMND], [Address], [Phone], [Job], [Gender], [Type], [Money]) VALUES (N'chuc', N'tkcho', N'chucmini', N'Nguyen Cong Chuc', CAST(N'2019-11-03' AS Date), 73492739, N'Nam Dinh', 23497234, N'Sinh Vien', 0, 1, 150000)
INSERT [dbo].[Account] ([Username], [Password], [Nickname], [Name], [Dob], [CMND], [Address], [Phone], [Job], [Gender], [Type], [Money]) VALUES (N'congminh', N'congminh', N'Tokuda', N'Nguyen Cong Minh', CAST(N'2019-09-25' AS Date), 237842999, N'Thach That', 964239013, N'SInh Vien', 0, 1, 600000)
INSERT [dbo].[Account] ([Username], [Password], [Nickname], [Name], [Dob], [CMND], [Address], [Phone], [Job], [Gender], [Type], [Money]) VALUES (N'manhminh', N'knnm1210', N'Manager', N'Minh', CAST(N'1999-10-12' AS Date), 26099000, N'Lập Thạch', 975403426, N'Manager', 1, 0, 0)
INSERT [dbo].[Customer] ([Username], [RID], [Name], [FID], [Checkin], [Checkout]) VALUES (N'congminh', N'R02', N'Nguyen Cong Minh', N'F02', CAST(N'2019-11-21' AS Date), CAST(N'2019-11-23' AS Date))
INSERT [dbo].[FormOfRent] ([FID], [Form]) VALUES (N'F01', N' Qua đêm')
INSERT [dbo].[FormOfRent] ([FID], [Form]) VALUES (N'F02', N'Theo ngày')
INSERT [dbo].[Invoice] ([Username], [RID], [SID], [InvoiceDate]) VALUES (N'congminh', N'R02', N'S01', CAST(N'2019-11-11' AS Date))
INSERT [dbo].[Invoice] ([Username], [RID], [SID], [InvoiceDate]) VALUES (N'congminh', N'R02', N'S03', CAST(N'2019-11-11' AS Date))
INSERT [dbo].[Invoice] ([Username], [RID], [SID], [InvoiceDate]) VALUES (N'congminh', N'R02', N'S01', CAST(N'2019-11-11' AS Date))
INSERT [dbo].[Invoice] ([Username], [RID], [SID], [InvoiceDate]) VALUES (N'chuc', N'R01', N'S03', CAST(N'2019-11-10' AS Date))
INSERT [dbo].[KindOfRoom] ([KID], [Kind]) VALUES (N'K01', N'Phòng đơn')
INSERT [dbo].[KindOfRoom] ([KID], [Kind]) VALUES (N'K02', N'Phòng đôi ')
INSERT [dbo].[KindOfRoom] ([KID], [Kind]) VALUES (N'K03', N'Phòng VIP')
INSERT [dbo].[PriceOfForm] ([PID], [KID], [FID], [Price]) VALUES (N'P01', N'K01', N'F01', 350000)
INSERT [dbo].[PriceOfForm] ([PID], [KID], [FID], [Price]) VALUES (N'P02', N'K02', N'F01', 450000)
INSERT [dbo].[PriceOfForm] ([PID], [KID], [FID], [Price]) VALUES (N'P03', N'K03', N'F01', 550000)
INSERT [dbo].[PriceOfForm] ([PID], [KID], [FID], [Price]) VALUES (N'P04', N'K01', N'F02', 500000)
INSERT [dbo].[PriceOfForm] ([PID], [KID], [FID], [Price]) VALUES (N'P05', N'K02', N'F02', 600000)
INSERT [dbo].[PriceOfForm] ([PID], [KID], [FID], [Price]) VALUES (N'P06', N'K03', N'F02', 700000)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R01', N'101', N'K01', 0)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R02', N'102', N'K01', 1)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R03', N'103', N'K01', 0)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R04', N'201', N'K02', 0)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R05', N'202', N'K02', 0)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R06', N'203', N'K02', 0)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R07', N'301', N'K03', 1)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R08', N'302', N'K03', 0)
INSERT [dbo].[Room] ([RID], [Roomnumber], [KID], [Status]) VALUES (N'R09', N'303', N'K03', 0)
INSERT [dbo].[Service] ([SID], [Name], [Price]) VALUES (N'S01', N'Đồ uống', 10000)
INSERT [dbo].[Service] ([SID], [Name], [Price]) VALUES (N'S02', N'Đồ ăn', 50000)
INSERT [dbo].[Service] ([SID], [Name], [Price]) VALUES (N'S03', N'Giặt là', 100000)
INSERT [dbo].[Service] ([SID], [Name], [Price]) VALUES (N'S04', N'Giữ xe', 50000)
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Account]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_FormOfRent] FOREIGN KEY([FID])
REFERENCES [dbo].[FormOfRent] ([FID])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_FormOfRent]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Room] FOREIGN KEY([RID])
REFERENCES [dbo].[Room] ([RID])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Room]
GO
ALTER TABLE [dbo].[History]  WITH CHECK ADD  CONSTRAINT [FK_History_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[History] CHECK CONSTRAINT [FK_History_Account]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Account] FOREIGN KEY([Username])
REFERENCES [dbo].[Account] ([Username])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_Account]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Room] FOREIGN KEY([RID])
REFERENCES [dbo].[Room] ([RID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_Room]
GO
ALTER TABLE [dbo].[Invoice]  WITH CHECK ADD  CONSTRAINT [FK_Invoice_Service] FOREIGN KEY([SID])
REFERENCES [dbo].[Service] ([SID])
GO
ALTER TABLE [dbo].[Invoice] CHECK CONSTRAINT [FK_Invoice_Service]
GO
ALTER TABLE [dbo].[PriceOfForm]  WITH CHECK ADD  CONSTRAINT [FK_PriceOfForm_FormOfRent] FOREIGN KEY([FID])
REFERENCES [dbo].[FormOfRent] ([FID])
GO
ALTER TABLE [dbo].[PriceOfForm] CHECK CONSTRAINT [FK_PriceOfForm_FormOfRent]
GO
ALTER TABLE [dbo].[PriceOfForm]  WITH CHECK ADD  CONSTRAINT [FK_PriceOfForm_KindOfRoom] FOREIGN KEY([KID])
REFERENCES [dbo].[KindOfRoom] ([KID])
GO
ALTER TABLE [dbo].[PriceOfForm] CHECK CONSTRAINT [FK_PriceOfForm_KindOfRoom]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_KindOfRoom] FOREIGN KEY([KID])
REFERENCES [dbo].[KindOfRoom] ([KID])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_KindOfRoom]
GO
