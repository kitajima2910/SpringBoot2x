USE [SpringBoot2x]
GO
/****** Object:  Table [dbo].[ABC]    Script Date: 2021-11-18 9:32:34 PM ******/
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
SET IDENTITY_INSERT [dbo].[ABC] ON 

INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (12, N'Test01', N'Hoai', CAST(N'2021-11-16 14:53:07.303' AS DateTime), N'Hoai', CAST(N'2021-11-16 15:01:19.297' AS DateTime), 1)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (13, N'Test10', N'Hoai', CAST(N'2021-11-16 15:30:10.173' AS DateTime), N'Hoai', CAST(N'2021-11-16 15:30:10.173' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (14, N'Update Test14', N'Hoai', CAST(N'2021-11-16 15:30:10.233' AS DateTime), N'Hoai', CAST(N'2021-11-16 15:43:41.567' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (15, N'Update Test15', N'Hoai', CAST(N'2021-11-16 15:30:55.337' AS DateTime), N'Hoai', CAST(N'2021-11-16 15:43:41.590' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (16, N'Update Test16', N'Hoai', CAST(N'2021-11-16 15:30:55.347' AS DateTime), N'Hoai', CAST(N'2021-11-16 16:51:18.207' AS DateTime), 0)
INSERT [dbo].[ABC] ([id], [name], [create_by], [create_date], [update_by], [update_date], [flag_del]) VALUES (17, N'Create Data 01', N'Hoai', CAST(N'2021-11-16 16:51:18.153' AS DateTime), N'Hoai', CAST(N'2021-11-16 16:51:18.153' AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[ABC] OFF
