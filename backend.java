import { Button, VerticalBox , LineEdit, StandardListView, GroupBox} from "std-widgets.slint";

        export component AppWindow inherits Window {

        in property <string> results: "";
        callback divide-income(string);
        in-out property <bool> open_curtain;
        animate background { duration: 800ms; }

        background: #313e50;

        GridLayout {
        padding: 50px;
        spacing: 25px;
        Row {
        text := Text {
        text: "Enter Total Income";
        horizontal-alignment: center;
        font-size: 24px;
        font-weight: 900;
        }
        }
        Row {
        input := LineEdit {
        placeholder-text: "Enter your number";
        font-size: 16px;
        height: 35px;
        horizontal-alignment: center;
        }
        }
        Row {
        button := Button {
        text: "Calculate";
        padding-top: 30px;
        height: 35px;
        primary: true;
        clicked => {
        root.open_curtain = !root.open_curtain;
        root.divide-income(input.text);
        }
        }
        }
        Row {
        VerticalBox {
        Rectangle {
        height: 100px;
        background: #f2f2f2;
        Text {
        text: root.results;
        font-size: 16px;
        color: #000000;
        font-weight: 500;
        }
        // Left curtain
        Rectangle {
        background: #333333;
        x: 0px;
        width: open_curtain ? 0px : (parent.width / 2);
        height: parent.height;
        animate width { duration: 250ms; easing: ease-in; }
        }

        // Right curtain
        Rectangle {
        background: #333333;
        x: open_curtain ? parent.width : (parent.width / 2);
        width: open_curtain ? 0px : (parent.width / 2);
        height: parent.height;
        animate width { duration: 250ms; easing: ease-in; }
        animate x { duration: 250ms; easing: ease-in; }
        }
        }
        }
        }
        }
        }