export default function TabBar({ $target, onClick }) {
  const $tabBar = document.createElement("div");
  $tabBar.className = "tab-bar";

  const tabs = ["all", "cat", "dog", "rabbit"];

  this.render = () => {
    $tabBar.innerHTML = tabs
      .map((tab) => `<div data-tab="${tab}">${tab.toUpperCase()}</div>`)
      .join("");
  };

  $tabBar.addEventListener("click", (e) => {
    if (e.target.dataset.tab) {
      // 이전 클릭된 탭 제거
      $tabBar
        .querySelectorAll(".clicked")
        .forEach((el) => el.classList.remove("clicked"));
      // 새로 클릭된 탭 표시
      e.target.classList.add("clicked");
      // 콜백 실행
      onClick(e.target.dataset.tab === "all" ? null : e.target.dataset.tab);
    }
  });

  $target.appendChild($tabBar);
  this.render();
}
