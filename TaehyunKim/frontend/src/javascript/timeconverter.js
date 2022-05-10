import moment from 'moment'

export const TimeConverter = {
    
    removeMicroseconds: function(dateList) {

        dateList.forEach((content) => {
            let regdate = moment(content.regdate)
            
            content.regdate = regdate.format("YYYY.MM.DD")
        })
    },

    removeMicrosecond: function(post){
        let regdate = moment(post.regdate)

        post.regdate = regdate.format("YYYY.MM.DD HH:mm:ss")
    },

    isCreatedToday: function(dateList) {
        dateList.forEach((content) => {
            let regdate = moment(content.regdate)

            let dateNow = moment()

            if (regdate.isSame(dateNow, "day"))
                content.regdate = regdate.format('HH:mm:ss')
            else{
                content.regdate = regdate.format('YYYY.MM.DD')
            }

        })
    },

    toDatesHoursFormat: function(dateList){
        dateList.forEach((content) => {
            let regdate = moment(content.regdate)

            content.regdate = regdate.format("YYYY.MM.DD HH:mm:ss")
        })
    }
}
