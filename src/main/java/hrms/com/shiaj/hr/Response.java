package hrms.com.shiaj.hr;


import org.springframework.http.HttpStatus;

/**
 * @author myb
 */
public class Response {
    private static final String OK = "ok";
    private static final String ERROR = "error";

    private Meta meta;
    private Object data;

    public Response success() {
        this.meta = new Meta(true, OK, HttpStatus.OK.value());
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(true, OK, HttpStatus.OK.value());
        this.data = data;
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, ERROR, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error");
        return this;
    }

    public Response failure(String message, int statusCode) {
        this.meta = new Meta(false, message, statusCode, "error");
        return this;
    }

    public Response failure(String message, int statusCode, String type) {
        this.meta = new Meta(false, message, statusCode, type);
        return this;
    }

    public Response failure(String message, int statusCode, String type, boolean isPopup) {
        this.meta = new Meta(false, message, statusCode, type, isPopup);
        return this;
    }

    public Response failure(String message, int statusCode, boolean isPopup, Object attendanceDuration) {
        this.meta = new Meta(false, message, statusCode, ERROR, isPopup, attendanceDuration);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    public static class Meta {

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        private String type;
        private boolean success;
        private String message;
        private int statusCode;
        private boolean popUp;
        private Object attendanceDuration;

        public Meta(boolean success) {
            this.success = success;
        }

        /**
         * HTTP响应附加信息包含状态，消息，状态码
         *
         * @param success    状态
         * @param message    消息
         * @param statusCode http状态码
         */
        public Meta(boolean success, String message, int statusCode) {
            this.success = success;
            this.message = message;
            this.statusCode = statusCode;
        }

        /**
         * HTTP响应附加信息包含状态，消息，状态码，类型，自动弹出消息
         *
         * @param success    状态
         * @param message    消息
         * @param statusCode http状态码
         * @param type       类型
         */
        public Meta(boolean success, String message, int statusCode, String type) {
            this.success = success;
            this.message = message;
            this.statusCode = statusCode;
            this.type = type;
            this.popUp = true;
        }

        /**
         * HTTP响应附加信息包含状态，消息，状态码，类型，是否自动弹出消息
         *
         * @param success    状态
         * @param message    消息
         * @param statusCode http状态码
         * @param type       类型
         * @param isPopup    是否自动弹出消息
         */
        public Meta(boolean success, String message, int statusCode, String type, boolean isPopup) {
            this.success = success;
            this.message = message;
            this.statusCode = statusCode;
            this.type = type;
            this.popUp = isPopup;
        }

        public Meta(boolean success, String message, int statusCode, String type, boolean isPopup, Object attendanceDuration) {
            this.success = success;
            this.message = message;
            this.statusCode = statusCode;
            this.type = type;
            this.popUp = isPopup;
            this.attendanceDuration = attendanceDuration;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public boolean isPopup() {
            return popUp;
        }

        public Object getAttendanceDuration() {
            return attendanceDuration;
        }
    }
}
