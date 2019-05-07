import pathlib

from flask import Flask, render_template, send_from_directory, flash, redirect, url_for, session, logging
app = Flask(__name__)


@app.route('/')
def hello_world():
    return render_template('index.html')

@app.route('/fish')
def fish():
    return render_template('fish.html') 



if __name__ == '__main__':
    app.run(debug=True)