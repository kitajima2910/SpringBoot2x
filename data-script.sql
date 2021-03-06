USE [SpringBoot2x]
GO
/****** Object:  Table [dbo].[ABC]    Script Date: 2021-12-10 1:18:17 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ABC](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NULL,
	[create_by] [varchar](50) NULL,
	[create_date] [datetime] NULL,
	[update_by] [varchar](50) NULL,
	[update_date] [datetime] NULL,
	[flag_del] [bit] NULL,
 CONSTRAINT [PK_TestTable] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = ON, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, FILLFACTOR = 3) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[User]    Script Date: 2021-12-10 1:18:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[username] [varchar](50) NOT NULL,
	[password] [varchar](255) NULL,
	[create_by] [varchar](50) NULL,
	[create_date] [datetime] NULL,
	[update_by] [varchar](50) NULL,
	[update_date] [datetime] NULL,
	[flag_del] [bit] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[ABC] ON 

INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (12, N'Test01', N'Hoai', CAST(N'2021-11-16 14:53:07.303' AS DateTime), N'Hoai', CAST(N'2021-11-16 15:01:19.297' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (13, N'Test10', N'Hoai', CAST(N'2021-11-16 15:30:10.173' AS DateTime), N'Hoai', CAST(N'2021-11-22 16:05:07.777' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (14, N'Update Test14', N'Hoai', CAST(N'2021-11-16 15:30:10.233' AS DateTime), N'Hoai', CAST(N'2021-11-16 15:43:41.567' AS DateTime), 1)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (15, N'Update Test15', N'Hoai', CAST(N'2021-11-16 15:30:55.337' AS DateTime), N'Hoai', CAST(N'2021-11-22 15:58:13.057' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (16, N'Update Test16', N'Hoai', CAST(N'2021-11-16 15:30:55.347' AS DateTime), N'Hoai', CAST(N'2021-11-22 15:58:13.077' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (17, N'Create Data 01', N'Hoai', CAST(N'2021-11-16 16:51:18.153' AS DateTime), N'Hoai', CAST(N'2021-11-16 16:51:18.153' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (18, N'Test01', N'Hoai', CAST(N'2021-11-26 20:43:15.610' AS DateTime), N'Hoai', CAST(N'2021-11-26 20:43:15.610' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[ABC] OFF
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user0', N'$2a$10$Hh2uGx9vWziOjWdzwyl7ceoFByfwumxq0V89HxqKN/uye4OjMAtRa', N'Hoai', CAST(N'2021-11-26 21:39:59.867' AS DateTime), N'Hoai', CAST(N'2021-11-26 21:39:59.867' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user01', N'$2a$12$pfrt7fymTifsYgRf.4Z4SeL5eM5RtAco3C225xef/EVU.2KXeY/oS', NULL, NULL, NULL, NULL, 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user02', N'$2a$10$A7Dtktghp/5CtDE/jMqsdOhdJlc3quPk/FPmAlAhsSwOttnaSqaKG', N'Hoai', CAST(N'2021-11-26 20:14:43.510' AS DateTime), N'Hoai', CAST(N'2021-11-26 20:14:43.510' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user03', N'$2a$10$HnrEEwARpW926uRBsoG1iuplVC8pf5plTj9VNloyIoTn3JjzZTEv.', N'Hoai', CAST(N'2021-11-26 21:08:07.190' AS DateTime), N'Hoai', CAST(N'2021-11-26 21:08:07.190' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user04', N'$2a$10$BfGlytTc1UW2UkLefdQEUekO8FaKseYGoS3JCJEqWCOvSt31KEH6S', N'Hoai', CAST(N'2021-11-26 21:22:21.547' AS DateTime), N'Hoai', CAST(N'2021-11-26 21:22:21.547' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user05', N'$2a$10$FaGRvzdbwGxRH2nKSquBN.JTEEeB1CBbhcSce0JZExx1jRWkKUw1a', N'Hoai', CAST(N'2021-11-26 21:25:01.610' AS DateTime), N'Hoai', CAST(N'2021-11-26 21:25:01.610' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user07', N'$2a$10$cZF2Jfej/.HBeGS9agjOsek8vwbyGpsJ9rDQaakMDthLWEsiilfJ6', N'Hoai', CAST(N'2021-11-26 21:53:30.320' AS DateTime), N'Hoai', CAST(N'2021-11-26 21:53:30.320' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user08', N'$2a$10$7UgKYtHr3UNycM5LAkK1JehUW9Vk0I.x9Ov7Gl6UW3OSlQVebI47a', N'Hoai', CAST(N'2021-11-26 22:49:51.733' AS DateTime), N'Hoai', CAST(N'2021-11-26 22:49:51.733' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user09', N'$2a$10$Ldpt7BKE5TfGkQ3ilcb1wutTOnNIefp5yQKG.hB9dPEPJxv5mttoO', N'Hoai', CAST(N'2021-11-26 22:54:30.257' AS DateTime), N'Hoai', CAST(N'2021-11-26 22:54:30.257' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user10', N'$2a$10$xT2l0dZ4oYBEZlOz8c2BgeCBzQs88ZEtVUnjyvAdLPz/8JP2Vodg.', N'Hoai', CAST(N'2021-11-26 22:59:36.683' AS DateTime), N'Hoai', CAST(N'2021-11-26 22:59:36.683' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user11', N'$2a$10$DsXsMCIXjwtdTuc1gxP3fO4hx8SzsIew.zXMyjD89JP5ZOiokR6pO', N'Hoai', CAST(N'2021-11-26 23:09:37.780' AS DateTime), N'Hoai', CAST(N'2021-11-26 23:09:37.780' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user12', N'$2a$10$3rsQ3Ny1yfXD3IHiscDjvucfwlnVJVS6SltDdmKksHo9eR6/39dBK', N'Hoai', CAST(N'2021-11-29 17:13:46.233' AS DateTime), N'Hoai', CAST(N'2021-11-29 17:13:46.233' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user13', N'$2a$10$nNJcuplLUuLY9DDGaVyQ9.4Za6uf4/o5DY8oIJJ64NgAY9RWM9UVm', N'Hoai', CAST(N'2021-11-30 13:14:37.470' AS DateTime), N'Hoai', CAST(N'2021-11-30 13:14:37.470' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user14', N'$2a$10$MKBjsuazuFD7YIvEWfIsbuvjYvRJg209mujDXxGNq1tN8FIxrrLsi', N'Hoai', CAST(N'2021-11-30 14:04:26.530' AS DateTime), N'Hoai', CAST(N'2021-11-30 14:04:26.530' AS DateTime), 0)
INSERT [dbo].[User] ([username], [password], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (N'user15', N'$2a$10$sZohScH7mP1ZCqEQqtw4QeZkFxgQ3rBNoq.IpOGNC7v5z58EB7gcS', N'Hoai', CAST(N'2021-12-01 10:19:16.287' AS DateTime), N'Hoai', CAST(N'2021-12-01 10:19:16.287' AS DateTime), 0)
/****** Object:  StoredProcedure [dbo].[spDeleteTestTableById]    Script Date: 2021-12-10 1:18:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[spDeleteTestTableById](@id int)
as
begin
	update abc
	set flag_del = 1
	where id = @id
end 
GO
/****** Object:  StoredProcedure [dbo].[spGetTestTableTop3]    Script Date: 2021-12-10 1:18:18 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[spGetTestTableTop3]
as
	select top 3 *
	from abc
GO
