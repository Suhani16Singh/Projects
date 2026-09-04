# Academix — Student Dashboard (Java Swing)

## Overview

Academix is a desktop student dashboard built entirely in core Java using
the Swing GUI toolkit. It gives a student a single screen to check their
identity details (name, roll number, semester), academic standing
(attendance, CGPA), pending coursework, and enrolled courses — without
requiring a browser, server, or any third-party framework.

The project is intentionally framework-free: everything is built on the
standard JDK (Swing, AWT, and `java.util`), which makes it easy to compile
and run anywhere a JDK is installed, and easy to read for anyone learning
how a desktop GUI application is structured.

## Features

- **Sidebar navigation** between four pages: Dashboard, Courses,
  Assignments, and Profile
- **Header bar** showing the student's name, roll number, and current
  semester on every page
- **Dashboard page** with four stat cards:
  - Attendance, shown as an animated circular progress ring
  - CGPA, with a status tag
  - Pending assignments, with a "due soon" count
  - Enrolled course count
- **Upcoming assignments list** on the Dashboard, showing only what's
  still pending
- **Courses page** listing every enrolled course with its code, name,
  and instructor
- **Assignments page** with the full, scrollable list of assignments and
  color-coded status pills (Upcoming / Due soon / Submitted)
- **Profile page** with a generated initials avatar and full student
  detail list
- **Custom-drawn UI components** (rounded cards, pill labels, progress
  ring) built with `Graphics2D`, since Swing has no built-in equivalents
- **Resizable window** with a sensible minimum size, so the layout holds
  up across different screen sizes

## Technologies

| Category         | Technology                          |
|-------------------|--------------------------------------|
| Language           | Java (written against Java 17+)      |
| GUI toolkit        | Swing (`javax.swing`)                |
| Graphics           | AWT / `Graphics2D` (`java.awt`)      |
| Build tooling      | None — compiled directly with `javac`|
| External libraries | None                                  |

## Requirements

- **JDK 17 or later** (Java Development Kit — not just a JRE, since you
  need `javac` to compile the source)
- A desktop OS with a graphical environment (Windows, macOS, or Linux
  with a display server) — this is a GUI app, not a console or web app
- No IDE is required; any text editor plus a terminal is enough

## Installation

1. Install a JDK if you don't already have one (17+ recommended).
   Verify it with:
   ```bash
   javac -version
   ```
2. Download or clone this project so that all `.java` files are together
   in one folder, e.g. `academix-dashboard/`.
3. No dependency installation is needed — there are no external
   libraries to fetch.

## How to Run

From inside the project folder:

```bash
# 1. Compile every source file
javac *.java

# 2. Launch the application
java Main
```

A window titled **"Academix — Student Dashboard"** should open at
1180×760, with a minimum size of 900×600.

## Example Usage

On launch, the app opens directly on the **Dashboard** page for a sample
student:

```
Welcome back, Aditi Sharma          21CSE1042 · 5th Semester

┌───────────────┬───────────────┬───────────────┬───────────────┐
│ Attendance     │ CGPA           │ Assignments    │ Courses        │
│     87%        │     8.64       │       3        │       6        │
│  On track      │ Good standing  │ 2 due soon     │ 5th Semester   │
└───────────────┴───────────────┴───────────────┴───────────────┘

Upcoming assignments
 • Process Scheduling Report   — Operating Systems  · Due 3 Sep 2026   [Due soon]
 • Normalization Worksheet     — Database Systems    · Due 5 Sep 2026  [Due soon]
 • Socket Programming Lab      — Computer Networks   · Due 10 Sep 2026 [Upcoming]
```

Clicking **Courses**, **Assignments**, or **Profile** in the sidebar
switches the main content area to that page while the header keeps
showing the student's name, roll number, and semester.

To try it with a different student, edit the values passed into
`Student` inside `SampleData.java`, then recompile:

```bash
javac *.java && java Main
```

## Project Structure

```
academix-dashboard/
├── Main.java              # Application entry point
├── DashboardFrame.java     # Main window; assembles sidebar, header, pages
│
├── Student.java            # Data model: student identity + academic stats
├── Course.java              # Data model: one enrolled course
├── Assignment.java          # Data model: one assignment + status enum
├── SampleData.java          # Builds sample student data for the demo
│
├── UITheme.java             # Shared colors, fonts, and layout constants
├── RoundedPanel.java         # Reusable rounded-corner card panel
├── RoundedLineBorder.java     # Reusable rounded outline border
├── PillLabel.java             # Reusable filled status pill label
├── AttendanceRing.java         # Circular attendance progress indicator
├── StatCard.java                # Reusable stat card used on the Dashboard
├── AssignmentRow.java            # Reusable assignment row component
│
├── Sidebar.java                   # Left navigation panel
├── HeaderPanel.java                 # Top bar with student identity
├── DashboardPanel.java               # Dashboard page
├── CoursesPanel.java                  # Courses page
├── AssignmentsPanel.java               # Assignments page
├── ProfilePanel.java                    # Profile page
│
└── README.md                              # This file
```

## Future Improvements

- Replace `SampleData.java` with real data loading (e.g., from a local
  file, database, or REST API), without changing any UI class
- Add a login/authentication screen to support more than one student
- Add search and filtering on the Assignments and Courses pages
- Persist changes (e.g., marking an assignment as submitted) between runs
- Add a settings page for theme (light/dark mode) and font size
- Add unit tests for the data model classes (`Student`, `Course`,
  `Assignment`)
- Package the app as a native installer using `jpackage` for easier
  distribution
- Add accessibility improvements (keyboard navigation, screen-reader
  friendly labels)
