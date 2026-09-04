const student = {
  name: "Suhani Singh",
  semester: "Semester 4 · Computer Science",
  attendance: "92%",
  cgpa: "8.6",
  assignmentSummary: "3 due",
  courseSummary: "5 enrolled",
};

const weekItems = [
  { title: "Data Structures lab", meta: "Wed, 10:00 AM" },
  { title: "Database assignment due", meta: "Fri, 11:59 PM" },
  { title: "Operating Systems quiz", meta: "Sat, 2:00 PM" },
];

const courses = [
  { title: "Data Structures", meta: "CS 201 · Dr. Rao" },
  { title: "Database Systems", meta: "CS 210 · Prof. Iyer" },
  { title: "Operating Systems", meta: "CS 220 · Dr. Khan" },
  { title: "Discrete Mathematics", meta: "MA 204 · Dr. Patel" },
  { title: "Web Development", meta: "CS 240 · Ms. Sharma" },
];

const assignments = [
  { title: "SQL queries worksheet", meta: "Due Friday" },
  { title: "Binary tree implementation", meta: "Due next Monday" },
  { title: "Process scheduling notes", meta: "Due next Wednesday" },
];

function fillList(id, items) {
  const list = document.getElementById(id);
  list.innerHTML = items
    .map(
      (item) =>
        `<li><span>${item.title}</span><span class="meta">${item.meta}</span></li>`
    )
    .join("");
}

function showSection(sectionId) {
  document.querySelectorAll(".view").forEach((view) => {
    view.classList.toggle("active", view.id === sectionId);
  });

  document.querySelectorAll(".nav-item").forEach((button) => {
    button.classList.toggle("active", button.dataset.section === sectionId);
  });

  closeSidebar();
}

function closeSidebar() {
  document.getElementById("sidebar").classList.remove("open");
  document.getElementById("overlay").classList.remove("show");
}

document.getElementById("studentName").textContent = student.name;
document.getElementById("profileName").textContent = student.name;
document.getElementById("currentSemester").textContent = student.semester;
document.getElementById("profileSemester").textContent = "Semester 4";
document.getElementById("attendanceValue").textContent = student.attendance;
document.getElementById("cgpaValue").textContent = student.cgpa;
document.getElementById("assignmentValue").textContent = student.assignmentSummary;
document.getElementById("courseValue").textContent = student.courseSummary;

fillList("weekList", weekItems);
fillList("courseList", courses);
fillList("assignmentList", assignments);

document.querySelectorAll(".nav-item").forEach((button) => {
  button.addEventListener("click", () => showSection(button.dataset.section));
});

document.getElementById("menuBtn").addEventListener("click", () => {
  document.getElementById("sidebar").classList.add("open");
  document.getElementById("overlay").classList.add("show");
});

document.getElementById("overlay").addEventListener("click", closeSidebar);
