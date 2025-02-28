export const formatDate = (date: Date) => {
  const format: Intl.DateTimeFormatOptions = {
    day: "2-digit",
    month: "2-digit",
    year: "numeric",
    hour: "2-digit",
    minute: "2-digit",
    second: "2-digit",
    hour12: false,
    timeZone: "America/Fortaleza",
  };

  return new Date(date).toLocaleString("pt-BR", format);
};
