export const PostUtility = {
    readFile: function(file) {

        return new Promise((resolve, reject) => {

            const reader = new FileReader()

            reader.onload = () => {
                resolve(reader.result)
            }

            reader.onerror = () => {
                reject(reader)
            }
            
            reader.readAsDataURL(file)
        })
    }
}
