function invokeAllMethods(obj) {
    Object
        .keys(obj.constructor.prototype)
        .map(name => obj[name])
        .filter(member => typeof member === 'function' && member.length === 0)
        .forEach(fn => console.log(fn.name + "() => " + fn.call(obj)))
}

// invokeAllMethods(new URL("https://isel.pt"))

invokeAllMethods(performance)
