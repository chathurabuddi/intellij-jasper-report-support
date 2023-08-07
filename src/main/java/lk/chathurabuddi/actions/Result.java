package lk.chathurabuddi.actions;

import java.util.Objects;
import java.util.StringJoiner;

public final class Result {
	private final ResultType type;
	private final String source;
	private final String destination;

	private final String message;
	private final Exception exception;

	public Result(ResultType type, String source, String destination, String message, Exception exception) {
		this.type = Objects.requireNonNull(type);
		this.source = Objects.requireNonNull(source);
		this.destination = Objects.requireNonNull(destination);
		this.message = message;
		this.exception = exception;
	}

	public static ResultBuilder builder() {
		return new ResultBuilder();
	}

	public ResultType getType() {
		return type;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public String getMessage() {
		return message;
	}

	public Exception getException() {
		return exception;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ").add("type=" + type)
		                             .add("source='" + source + "'")
		                             .add("destination='" + destination + "'")
		                             .add("message='" + message + "'")
		                             .add("exception=" + exception)
		                             .toString();
	}

	public static final class ResultBuilder {
		private ResultType type;
		private String source;
		private String destination;
		private String message;
		private Exception exception;

		private ResultBuilder() {}

		public ResultBuilder type(ResultType type) {
			this.type = type;
			return this;
		}

		public ResultBuilder source(String source) {
			this.source = source;
			return this;
		}

		public ResultBuilder destination(String destination) {
			this.destination = destination;
			return this;
		}

		public ResultBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ResultBuilder exception(Exception exception) {
			this.exception = exception;
			return this;
		}

		public String getSource() {
			return source;
		}

		public String getDestination() {
			return destination;
		}

		public Result build() {
			return new Result(type, source, destination, message, exception);
		}
	}
}
