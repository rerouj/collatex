<!DOCTYPE html>
<html>
<head>
  <title>CollateX</title>
  <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/combo?3.6.0/build/cssfonts/cssfonts-min.css&3.6.0/build/cssgrids/cssgrids-min.css&3.6.0/build/cssreset/cssreset-min.css&3.6.0/build/cssbase/cssbase-min.css&3.6.0/build/cssbutton/cssbutton-min.css">
  <style type="text/css">
    body { width: 960px; margin: 2em auto; padding: 1em; border: 1px solid #808080; border-radius: 1em }
    a, a:visited, a:link, a:active, a:hover { color: #9D9DCB; text-decoration: none; font-weight: bold; }
    #content { font-size: 108%; }
    #start { text-align: center; margin: 2em }
    #start a { display: inline-block; color: #fff; background: #9D9DCB; padding: 1em; box-shadow: 0.5em 0.5em 0.5em #808080; font-size: larger; }
    #footer { margin-top: 3em; text-align: center; color: #808080; }
    .note { font-style: italic; }
  </style>
</head>
<body>
  <div id="content">
    <h1>What is Interedition?</h1>

    <p><a href="http://www.interedition.eu/" title="Interedition Homepage">Interedition</a> is a
      <a href="http://www.cost.esf.org/" title="ESF COST Homepage">European-funded</a> development
      <a href="https://github.com/interedition/" title="GitHub Homepage">collective</a> whose aim it is to promote the
      interoperability of the tools and methodology we use in the field of digital scholarly editing and research.</p>

    <h1>What are Microservices?</h1>

    <p>Microservices are small
      <a href="http://en.wikipedia.org/wiki/Representational_state_transfer" title="Wikipedia: REST">RESTful web services</a>
      supporting specific tasks in any digital work flow pertaining to larger scholarly tasks. They are the small
      reusable web published building blocks of digital scholarly tools. They provide the basic solution to
      interoperability and sustainability for digital scholarly tools Interedition is striving for.</p>

    <h1>How do I run them?</h1>

    <p>As Interedition Microservices mainly serve as building blocks for other (client) software in a networked environment,
      they are normally deployed on highly available servers with a permanent connection to the Internet. For
      development and testing purposes as well as for smaller projects though, we provide a standalone application that
      allows you to run them on your desktop computer.</p>
    
    <p>In order to run the standalone application, all you need is a current
      <a href="http://java.com/" title="Java Homepage">Java Runtime Environment</a>. Optionally you should also have
      <a href="http://graphviz.org/" title="GraphViz Homepage">GraphViz</a> installed as some of the services make
      use of its graph rendering capabilities in order to visualize results.</p>
    
    <p>If you have Java installed, just click on the following link in order to download and start the application.</p>

    <div id="start"><a href="server.jnlp" title="Interedition Microservices: Java Web Start">Run an Interedition Node</a></div>
    
    <p class="note"><strong>Note:</strong> Please ignore the security warning popping up after the download,
      &ldquo;trust us&rdquo; and grant the application access to your machine. After the download has successfully completed, you can
      run the whole application offline as well.</p>

    <h1>Where to go from here?</h1>

    <p>If you have further questions and/or would like to give us feedback, please do not hesitate to 
      <a href="mailto:info@huygensinstituut.knaw.nl" title="E-Mail">contact us</a> or contribute to our <a href="http://www.interedition.eu/wiki/" title="Wiki">Wiki</a>.</p>
  </div>

  <div id="footer">
    Interedition Microservices 1.3-SNAPSHOT. Copyright &copy; 2011, 2012 The Interedition Development Group. All rights reserved.<br>
    See the <a href="http://www.interedition.eu/" title="Interedition Homepage">Interedition Homepage</a> for further information.
  </div>
</body>
</html>