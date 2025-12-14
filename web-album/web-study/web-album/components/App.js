import TabBar from "./TabBar.js";
import Content from "./Content.js";

export default function App($app) {
  this.$app = $app;
  this.state = {
    currentTab: null,
    photos: [],
  };

  const $tabBar = document.createElement("div");
  const $content = document.createElement("div");

  this.$app.appendChild($tabBar);
  this.$app.appendChild($content);

  this.tabBar = new TabBar({
    $target: $tabBar,
    onClick: (tab) => {
      this.setState({
        ...this.state,
        currentTab: tab,
      });
    },
  });

  this.content = new Content({
    $target: $content,
    initialState: this.state,
  });

  this.setState = (newState) => {
    this.state = newState;
    this.content.setState(this.state);
  };
}
