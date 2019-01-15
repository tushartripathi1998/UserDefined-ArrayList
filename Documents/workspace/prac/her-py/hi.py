from flask import Flask
app=Flask(__name__)

@app.route('/')
def name():
    return '''Hi'''
app.run(debug=True)
