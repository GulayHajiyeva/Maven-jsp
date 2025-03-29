<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Form with Bootstrap</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4">Search Form</h2>

    <!-- Form -->
    <form id="searchForm">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" placeholder="Enter name">
        </div>
        <div class="mb-3">
            <label for="surname" class="form-label">Surname</label>
            <input type="text" class="form-control" id="surname" placeholder="Enter surname">
        </div>
        <div class="mb-3">
            <label for="subject" class="form-label">Subject</label>
            <input type="text" class="form-control" id="subject" placeholder="Enter subject">
        </div>
        <div class="mb-3">
            <label for="salary" class="form-label">Salary</label>
            <input type="number" class="form-control" id="salary" placeholder="Enter salary">
        </div>
        <button type="button" class="btn btn-primary" onclick="addRow()">Search</button>
    </form>

    <!-- Table -->
    <h3 class="mt-5">Search Results</h3>
    <table class="table table-bordered" id="resultTable">
        <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Subject</th>
                <th>Salary</th>
            </tr>
        </thead>
        <tbody>
            <!-- Data rows will appear here -->
        </tbody>
    </table>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<script>
    function addRow() {
        const name = document.getElementById('name').value;
        const surname = document.getElementById('surname').value;
        const subject = document.getElementById('subject').value;
        const salary = document.getElementById('salary').value;

        if (name && surname && subject && salary) {
            const table = document.getElementById('resultTable').getElementsByTagName('tbody')[0];
            const newRow = table.insertRow();

            newRow.insertCell(0).innerText = name;
            newRow.insertCell(1).innerText = surname;
            newRow.insertCell(2).innerText = subject;
            newRow.insertCell(3).innerText = salary;
        } else {
            alert("Please fill in all fields.");
        }
    }
</script>

</body>
</html>
