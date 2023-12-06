USE [PRJ301_SE1758_FA23]
GO
/****** Object:  Table [dbo].[Account_HE172180]    Script Date: 09/11/2023 09:54:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account_HE172180](
	[uID] [int] IDENTITY(1,1) NOT NULL,
	[user] [varchar](255) NULL,
	[pass] [varchar](255) NULL,
	[isSell] [int] NULL,
	[isAdmin] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[uID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cart_HE172180]    Script Date: 09/11/2023 09:54:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cart_HE172180](
	[accountId] [int] NOT NULL,
	[productId] [int] NULL,
	[amount] [int] NULL,
 CONSTRAINT [PK_Cart] PRIMARY KEY CLUSTERED 
(
	[accountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category_HE172180]    Script Date: 09/11/2023 09:54:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category_HE172180](
	[cid] [int] NOT NULL,
	[cname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Log_HE172180]    Script Date: 09/11/2023 09:54:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Log_HE172180](
	[logId] [int] IDENTITY(1,1) NOT NULL,
	[accountId] [int] NULL,
	[productId] [int] NULL,
	[amount] [int] NULL,
	[address] [nvarchar](255) NULL,
	[number] [int] NULL,
	[date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[logId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product_HE172180]    Script Date: 09/11/2023 09:54:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_HE172180](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](max) NULL,
	[image] [nvarchar](max) NULL,
	[price] [money] NULL,
	[title] [nvarchar](max) NULL,
	[description] [nvarchar](max) NULL,
	[cateID] [int] NULL,
	[sell_ID] [int] NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account_HE172180] ON 

INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (1, N'Adam', N'123', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (2, N'Anjolie', N'SNZ6HE', 0, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (3, N'Ferris', N'RXH3XJ', 0, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (4, N'Katell', N'HWV8ZN', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (5, N'Zahir', N'NPX7OF', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (6, N'Conan', N'WIZ5VZ', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (7, N'Cade', N'ZSW2LU', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (8, N'Micah', N'RVV5SR', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (9, N'Rowan', N'VAI6XR', 1, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (10, N'Kirby', N'DNX6JK', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (11, N'Tanisha', N'XWU7JP', 0, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (12, N'Howard', N'TSR5MR', 0, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (13, N'Tana', N'EHS8CM', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (14, N'Hadassah', N'YOY7ZW', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (15, N'Echo', N'IGE8TN', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (16, N'Slade', N'OFO6QS', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (17, N'Devin', N'IBM6RZ', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (18, N'Rowan', N'ZYS9VI', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (19, N'Rafael', N'WZA0IH', 1, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (20, N'Madaline', N'QMW4EN', 0, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (21, N'Vera', N'CZB2VM', 0, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (22, N'Declan', N'123', 1, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (23, N'Katell', N'SFS0IW', 1, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (24, N'Summer', N'PSQ7LC', 0, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (25, N'Robin', N'KIS9AF', 1, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (26, N'Dominique', N'IKV0IX', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (27, N'admin', N'123', 1, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (28, N'mra', N'mra', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (29, N'mrb', N'123', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (30, N'Camden', N'123', 0, 0)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (1004, N'bach', N'kamikaze', 1, 1)
INSERT [dbo].[Account_HE172180] ([uID], [user], [pass], [isSell], [isAdmin]) VALUES (2001, N'bach', N'shdb', 1, 1)
SET IDENTITY_INSERT [dbo].[Account_HE172180] OFF
GO
INSERT [dbo].[Category_HE172180] ([cid], [cname]) VALUES (1, N'Bát sen')
INSERT [dbo].[Category_HE172180] ([cid], [cname]) VALUES (2, N'Ống xả')
INSERT [dbo].[Category_HE172180] ([cid], [cname]) VALUES (3, N'Dây cấp')
INSERT [dbo].[Category_HE172180] ([cid], [cname]) VALUES (4, N'Đầu vòi')
GO
SET IDENTITY_INSERT [dbo].[Log_HE172180] ON 

INSERT [dbo].[Log_HE172180] ([logId], [accountId], [productId], [amount], [address], [number], [date]) VALUES (9, 1, 1, 1, N'ND', 147852369, CAST(N'2023-11-03' AS Date))
INSERT [dbo].[Log_HE172180] ([logId], [accountId], [productId], [amount], [address], [number], [date]) VALUES (10, 1, 7, 7, N'HP', 11111111, CAST(N'2023-11-01' AS Date))
SET IDENTITY_INSERT [dbo].[Log_HE172180] OFF
GO
SET IDENTITY_INSERT [dbo].[Product_HE172180] ON 

INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (1, N'Bát sen 01', N'img\1.jpg', 75.0000, N'Dùng cho nhà tắm', N'Tam trung', 1, 1)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (2, N'Bát sen 02', N'img\2.jpg', 63.0000, N'Dùng cho nhà tắm', N'Giá rẻ', 1, 6)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (3, N'Bát sen 05', N'img\5.jpg', 70.0000, N'Dùng cho nhà tắm', N'Giá rẻ', 1, 6)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (5, N'Ống xả lavabo', N'img\8.jpg', 42.0000, N'Dùng cho chậu rửa bát', N'Tầm trung', 2, 15)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (6, N'Dây cấp đầu kim', N'img\10.jpg', 49.0000, N'Dùng cho bồn rửa mặt', N'Tầm trung', 3, 15)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (7, N'Đầu vòi củ', N'img\12.jpg', 35.0000, N'Dùng cho nhà bếp', N'Tầm trung', 4, 7)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (8, N'Bát sen 03', N'img\3.jpg', 89.0000, N'Dùng cho nhà tắm', N'Cao cấp', 1, 7)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (9, N'Bát sen 04', N'img\4.jpg', 75.0000, N'Dùng cho nhà tắm', N'Tầm trung', 1, 1)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (10, N'Bát sen 06', N'img\6.jpg', 85.0000, N'Dùng cho nhà tắm', N'Cao cấp', 1, 7)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (11, N'Bát sen 07', N'img\7.jpg', 75.0000, N'Dùng cho nhà tắm', N'Tầm trung', 1, 14)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (12, N'Dây cấp 2 đầu', N'img\9.jpg', 49.0000, N'Dùng cho bồn rửa mặt', N'Tầm trung', 3, 1)
INSERT [dbo].[Product_HE172180] ([id], [name], [image], [price], [title], [description], [cateID], [sell_ID]) VALUES (13, N'Đầu vòi loa', N'img\11.jpg', 35.0000, N'Dùng cho nhà bếp', N'Tầm trung', 4, 15)
SET IDENTITY_INSERT [dbo].[Product_HE172180] OFF
GO
ALTER TABLE [dbo].[Cart_HE172180]  WITH CHECK ADD  CONSTRAINT [FK_Cart_Account] FOREIGN KEY([accountId])
REFERENCES [dbo].[Account_HE172180] ([uID])
GO
ALTER TABLE [dbo].[Cart_HE172180] CHECK CONSTRAINT [FK_Cart_Account]
GO
ALTER TABLE [dbo].[Log_HE172180]  WITH CHECK ADD  CONSTRAINT [FK_Log_Account] FOREIGN KEY([accountId])
REFERENCES [dbo].[Account_HE172180] ([uID])
GO
ALTER TABLE [dbo].[Log_HE172180] CHECK CONSTRAINT [FK_Log_Account]
GO
ALTER TABLE [dbo].[Product_HE172180]  WITH CHECK ADD  CONSTRAINT [FK_product_Account] FOREIGN KEY([sell_ID])
REFERENCES [dbo].[Account_HE172180] ([uID])
GO
ALTER TABLE [dbo].[Product_HE172180] CHECK CONSTRAINT [FK_product_Account]
GO
ALTER TABLE [dbo].[Product_HE172180]  WITH CHECK ADD  CONSTRAINT [FK_product_Category] FOREIGN KEY([cateID])
REFERENCES [dbo].[Category_HE172180] ([cid])
GO
ALTER TABLE [dbo].[Product_HE172180] CHECK CONSTRAINT [FK_product_Category]
GO
