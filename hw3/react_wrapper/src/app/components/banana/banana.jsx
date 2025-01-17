import React from "react"
var ReactScriptLoaderMixin = require('react-script-loader').ReactScriptLoaderMixin;


var Banana = React.createClass({

    mixins: [ReactScriptLoaderMixin],
    getInitialState: function () {
        return {
            scriptLoading: true,
            scriptLoadError: false,
        };
    },

    // this function tells ReactScriptLoaderMixin where to load the script from
    getScriptURL: function () {
        return 'js/iframeResizer.min.js';
    },

    // ReactScriptLoaderMixin calls this function when the script has loaded
    // successfully.
    onScriptLoaded: function () {
        this.setState({scriptLoading: false});
    },

    // ReactScriptLoaderMixin calls this function when the script has failed to load.
    onScriptError: function () {
        this.setState({scriptLoading: false, scriptLoadError: true});
    },

    localIframeResize() {
        "use strict";
        //console.log(this.refs.iframe1.style.height + "");
        //this.refs.iframe1.style.height = this.refs.iframe1.contentWindow.document.body.scrollHeight + 'px';
        iFrameResize({log:true})
    },
    render() {
        "use strict";
        var _style = {
            width: "100%",
        };
        var message;
        if (this.state.scriptLoading) {
            message = 'loading script...';
        } else if (this.state.scriptLoadError) {
            message = 'loading failed';
        } else {
            message = 'loading succeeded';
            this.localIframeResize();
        }
        return (
            <div style={_style}>
                <iframe src="http://localhost:8983/solr/banana/src/index.html" width="100%" height="1280px" scrolling="yes"
                        frameBorder="0"></iframe>

            </div>
        );
    }

});
export default Banana;
