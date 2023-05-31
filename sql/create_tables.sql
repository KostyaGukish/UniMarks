USE [UniMarks]
GO

/****** Object:  Table [dbo].[pevaluation]    Script Date: 30.05.2023 16:29:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[pevaluation](
	[id] [int] NOT NULL,
	[subject_id] [int] NULL,
	[mark] [int] NULL,
	[attendance] [tinyint] NULL,
	[date] [date] NULL,
	[student_id] [int] NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [UniMarks]
GO

/****** Object:  Table [dbo].[pgroup]    Script Date: 30.05.2023 16:29:27 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[pgroup](
	[id] [int] NOT NULL,
	[GroupDescription] [nchar](200) NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [UniMarks]
GO

/****** Object:  Table [dbo].[pschedule]    Script Date: 30.05.2023 16:29:52 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[pschedule](
	[id] [int] NOT NULL,
	[group_id] [int] NULL,
	[subject_id] [int] NULL,
	[week_day] [int] NULL,
	[number] [int] NULL,
 CONSTRAINT [PK__schedule__3213E83FDE65F350] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [UniMarks]
GO

/****** Object:  Table [dbo].[pstudent]    Script Date: 30.05.2023 16:30:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[pstudent](
	[id] [int] NOT NULL,
	[name] [nchar](20) NULL,
	[surname] [nchar](20) NULL,
	[patronymic] [nchar](20) NULL,
	[group_id] [int] NULL,
 CONSTRAINT [PK_pstudent] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [UniMarks]
GO

/****** Object:  Table [dbo].[psubject]    Script Date: 30.05.2023 16:30:24 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[psubject](
	[id] [int] NOT NULL,
	[name] [nchar](45) NOT NULL,
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [UniMarks]
GO

/****** Object:  Table [dbo].[pteacher]    Script Date: 30.05.2023 16:30:39 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[pteacher](
	[id] [int] NOT NULL,
	[name] [nchar](20) NULL,
	[surname] [nchar](20) NULL,
	[patronymic] [nchar](20) NULL,
	[subject_id] [int] NULL,
	[group_id] [int] NULL,
 CONSTRAINT [PK_pteacher] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

USE [UniMarks]
GO

/****** Object:  Table [dbo].[puser]    Script Date: 30.05.2023 16:30:56 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[puser](
	[login] [nchar](20) NOT NULL,
	[password] [nchar](20) NULL,
	[teacher_id] [int] NULL,
	[student_id] [int] NULL,
 CONSTRAINT [PK_puser] PRIMARY KEY CLUSTERED
(
	[login] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[puser]  WITH CHECK ADD  CONSTRAINT [FK_puser_pstudent] FOREIGN KEY([student_id])
REFERENCES [dbo].[pstudent] ([id])
GO

ALTER TABLE [dbo].[puser] CHECK CONSTRAINT [FK_puser_pstudent]
GO

ALTER TABLE [dbo].[puser]  WITH CHECK ADD  CONSTRAINT [FK_puser_pteacher] FOREIGN KEY([teacher_id])
REFERENCES [dbo].[pteacher] ([id])
GO

ALTER TABLE [dbo].[puser] CHECK CONSTRAINT [FK_puser_pteacher]
GO

ALTER TABLE [dbo].[pteacher]  WITH CHECK ADD  CONSTRAINT [FK_pteacher_pgroup] FOREIGN KEY([group_id])
REFERENCES [dbo].[pgroup] ([id])
GO

ALTER TABLE [dbo].[pteacher] CHECK CONSTRAINT [FK_pteacher_pgroup]
GO

ALTER TABLE [dbo].[pteacher]  WITH CHECK ADD  CONSTRAINT [FK_pteacher_psubject] FOREIGN KEY([subject_id])
REFERENCES [dbo].[psubject] ([id])
GO

ALTER TABLE [dbo].[pteacher] CHECK CONSTRAINT [FK_pteacher_psubject]
GO

ALTER TABLE [dbo].[pstudent]  WITH CHECK ADD  CONSTRAINT [FK_pstudent_pgroup] FOREIGN KEY([group_id])
REFERENCES [dbo].[pgroup] ([id])
GO

ALTER TABLE [dbo].[pstudent] CHECK CONSTRAINT [FK_pstudent_pgroup]
GO

ALTER TABLE [dbo].[pschedule] ADD  CONSTRAINT [DF__schedule__subjec__0A338187]  DEFAULT (NULL) FOR [subject_id]
GO

ALTER TABLE [dbo].[pschedule] ADD  CONSTRAINT [DF__schedule__day__0B27A5C0]  DEFAULT (NULL) FOR [week_day]
GO

ALTER TABLE [dbo].[pschedule] ADD  CONSTRAINT [DF__schedule__number__0C1BC9F9]  DEFAULT (NULL) FOR [number]
GO

ALTER TABLE [dbo].[pschedule]  WITH CHECK ADD  CONSTRAINT [FK_pschedule_pgroup] FOREIGN KEY([group_id])
REFERENCES [dbo].[pgroup] ([id])
GO

ALTER TABLE [dbo].[pschedule] CHECK CONSTRAINT [FK_pschedule_pgroup]
GO

ALTER TABLE [dbo].[pschedule]  WITH CHECK ADD  CONSTRAINT [FK_pschedule_psubject] FOREIGN KEY([subject_id])
REFERENCES [dbo].[psubject] ([id])
GO

ALTER TABLE [dbo].[pschedule] CHECK CONSTRAINT [FK_pschedule_psubject]
GO

ALTER TABLE [dbo].[pgroup] ADD  DEFAULT (NULL) FOR [GroupDescription]
GO

ALTER TABLE [dbo].[pevaluation] ADD  DEFAULT (NULL) FOR [subject_id]
GO

ALTER TABLE [dbo].[pevaluation] ADD  DEFAULT (NULL) FOR [mark]
GO

ALTER TABLE [dbo].[pevaluation] ADD  DEFAULT (NULL) FOR [attendance]
GO

ALTER TABLE [dbo].[pevaluation] ADD  DEFAULT (NULL) FOR [date]
GO

ALTER TABLE [dbo].[pevaluation] ADD  DEFAULT (NULL) FOR [student_id]
GO

ALTER TABLE [dbo].[pevaluation]  WITH CHECK ADD  CONSTRAINT [FK_evaluation_subject] FOREIGN KEY([subject_id])
REFERENCES [dbo].[psubject] ([id])
GO

ALTER TABLE [dbo].[pevaluation] CHECK CONSTRAINT [FK_evaluation_subject]
GO

ALTER TABLE [dbo].[pevaluation]  WITH CHECK ADD  CONSTRAINT [FK_pevaluation_pstudent] FOREIGN KEY([student_id])
REFERENCES [dbo].[pstudent] ([id])
GO

ALTER TABLE [dbo].[pevaluation] CHECK CONSTRAINT [FK_pevaluation_pstudent]
GO


