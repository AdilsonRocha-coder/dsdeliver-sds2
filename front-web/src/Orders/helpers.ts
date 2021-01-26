import { Product } from "./types";

export function checkIsSelected(selectedProducts: Product[], product: Product) {
  return selectedProducts.some((item) => item.id === product.id);
}

export function formatPrice(price: number) {
  const formatter = new Intl.NumberFormat("pt-BR", {
    style: "currency",
    currency: "BRL",
    minimumFractionDigits: 2, //é padrão já vir com 2 dígitos. Caso quisésemos mais casas, bastava aumentar aqui.
  });

  return formatter.format(price);
}
