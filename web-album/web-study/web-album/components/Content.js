import { request } from "./api.js";

export default function Content({ $target, initialState }) {
  const $content = document.createElement("div");
  $content.className = "content";

  this.state = initialState;

  this.setState = (newState) => {
    this.state = newState;
    this.fetchAndRender();
  };

  this.fetchAndRender = async () => {
    const photos = await request(this.state.currentTab);
    this.render(photos);
  };

  this.render = (photos) => {
    if (!photos || photos.length === 0) {
      $content.innerHTML = "<p>Loading...</p>";
      return;
    }

    $content.innerHTML = photos
      .map((photo) => `<img src="${photo.url}" alt="${photo.name}" />`)
      .join("");
  };

  $target.appendChild($content);
  this.fetchAndRender();
}
