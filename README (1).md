# StudentHub — Student Dashboard

A clean, responsive student academic portal built with plain HTML, CSS, and JavaScript. It gives students a quick snapshot of their attendance, CGPA, courses, and upcoming assignments in a single-page dashboard.

## Features

- **Dashboard overview** — at-a-glance cards for attendance %, CGPA, pending assignments, and enrolled course count
- **This Week panel** — upcoming labs, quizzes, and due dates
- **Courses view** — list of all enrolled courses with course codes and instructors
- **Assignments view** — upcoming assignments with due dates
- **Profile view** — student details including ID, semester, program, email, and advisor
- **Responsive sidebar navigation** — collapses into a slide-out menu with overlay on mobile/tablet screens
- **No dependencies** — pure HTML/CSS/JS, no frameworks or build tools required

## Project Structure

```
├── index.html      # Page structure and layout
├── style.css       # Styling, theme colors, and responsive design
├── script.js       # Data, rendering logic, and navigation behavior
└── .vscode/        # Editor configuration
```

## Getting Started

No installation or build step is needed.

1. Clone or download this repository
2. Open `index.html` in your browser

   OR, for a live-reload experience, serve it with a simple local server, e.g.:
   ```
   npx serve .
   ```
   or, if you have Python installed:
   ```
   python -m http.server
   ```
3. Navigate to `http://localhost:<port>` in your browser

## Customization

All student and academic data currently lives in `script.js` as plain JavaScript objects/arrays:

- `student` — name, semester, attendance, CGPA, and summary values
- `weekItems` — this week's schedule
- `courses` — enrolled courses list
- `assignments` — upcoming assignments list

Update these values to connect the dashboard to real student data, or wire them up to an API call in a future iteration.

Theme colors (currently a cherry-red palette) can be adjusted via the CSS custom properties at the top of `style.css`:

```css
:root {
  --cherry: #c41e3a;
  --accent: #c41e3a;
  --bg: #ffffff;
  --text: #2a1216;
  ...
}
```

## Responsive Behavior

- **Desktop (>980px):** Full 4-column card grid with a fixed sidebar
- **Tablet (≤980px):** 2-column card grid
- **Mobile (≤760px):** Single-column layout with a collapsible sidebar toggled via the menu button

## Tech Stack

- HTML5
- CSS3 (custom properties, flexbox, grid, media queries)
- Vanilla JavaScript (DOM manipulation, no framework)

## License

This project is free to use and modify for personal or educational purposes.
