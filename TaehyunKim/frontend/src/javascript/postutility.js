export const PostUtility = {
    AddFile: function(e, files, preview) {
        console.log(e.target.files)


    for (let i = 0; i<e.target.files.length; i++){
        const reader = new FileReader()
        let file = e.target.files[i]

        if (file.type.match(/image.*/)){
            console.log("Match: ", file.name)
            files.push(e.target.files[i])
            reader.readAsDataURL(e.target.files[i])
            reader.onload = () => {
            preview.push(reader.result)
            }
        }
        else{
            console.log("Not an image: ", file.name)
        }
    }
    }
}
