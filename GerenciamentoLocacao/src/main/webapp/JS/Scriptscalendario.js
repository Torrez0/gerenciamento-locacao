async function fillCalendar() {
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = currentDate.getMonth();
  const daysInMonth = new Date(year, month + 1, 0).getDate();
  const calendar = document.getElementById("calendar");
  calendar.innerHTML = '';

  const availabilityCache = {};

  for (let i = 0; i < 6; i++) {
    const row = calendar.insertRow(i);

    for (let j = 0; j < 7; j++) {
      const cell = row.insertCell(j);

      if (i === 0 && j < new Date(year, month, 1).getDay()) {
        continue;
      }

      if (i * 7 + j + 1 > daysInMonth) {
        break;
      }

      const date = new Date(year, month, i * 7 + j + 1);
      const dateString = formatDate(date);

      let isAvailable = availabilityCache[dateString];
      if (isAvailable === undefined) {
        isAvailable = await fetchAvailability(dateString);
        availabilityCache[dateString] = isAvailable;
      }

      cell.innerHTML = date.getDate();
      cell.setAttribute("data-date", dateString);
      cell.className = isAvailable ? "available" : "booked";
    }
  }
}

function formatDate(date) {
  const year = date.getFullYear();
  const month = (date.getMonth() + 1).toString().padStart(2, '0');
  const day = date.getDate().toString().padStart(2, '0');
  return `${year}-${month}-${day}`;
}

async function fetchAvailability(date) {
  // Implementação da função de consulta ao banco de dados
  // ...
}

async function reserveDate(event) {
  const target = event.target;
  if (target.tagName === "TD" && target.classList.contains("available")) {
    const date = target.getAttribute("data-date");
    const isAvailable = await fetchAvailability(date);

    if (isAvailable) {
      // Lógica para reservar a data no backend
      // Por exemplo, você pode enviar uma requisição POST para o servidor para registrar a reserva
      console.log(`Data ${date} reservada!`);

      // Atualiza visualmente o calendário após a reserva
      fillCalendar();
    } else {
      console.log(`Data ${date} já reservada!`);
    }
  }
}

fillCalendar();